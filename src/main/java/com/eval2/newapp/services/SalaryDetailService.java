package com.eval2.newapp.services;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.eval2.newapp.models.Employe;
import com.eval2.newapp.models.SalaryAssignment;
import com.eval2.newapp.models.SalaryDetail;
import com.eval2.newapp.models.SalaryDetailDTO;
import com.eval2.newapp.models.SalarySlip;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class SalaryDetailService {
    
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private EmployeService employeService;
    @Autowired
    private SalarySlipService salarySlipService;
    @Autowired
    private SalaryAssignmentService salaryAssignmentService;

    public List<SalaryDetailDTO> findAllFilterByComponentCondition(String salaryComponent, double amount, String condition) throws Exception {
        String url = "http://erpnext.localhost:8000/api/method/hrms.payroll.doctype.salary_detail.salary_detail.get_all_by_components_condition?component="+salaryComponent+"&amount="+amount+"&condition="+condition;
        
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "token "+ApiKeyService.getAPiKey());

        HttpEntity<Void> entity = new HttpEntity<>(headers);
        ResponseEntity<JsonNode> response = restTemplate.exchange(url, HttpMethod.GET, entity, JsonNode.class);

        JsonNode dataNode = response.getBody().get("message");
        SalaryDetailDTO[] rfqs = objectMapper.treeToValue(dataNode, SalaryDetailDTO[].class);

        return Arrays.asList(rfqs);
    }

    public double sumSalaryBase(List<SalaryDetail> salaryDetails) {
        double sum = 0;

        for (SalaryDetail salaryDetail : salaryDetails) {
            sum += salaryDetail.getSalaryAssignment().getBase();
        }
    
        return sum;
    }

    public double sumSalaryComponent(List<SalaryDetail> salaryDetails, String componentType) {
        double sum = 0;

        if (componentType.toLowerCase().equals("earnings")) {
            for (SalaryDetail salaryDetail : salaryDetails) {
                sum += salaryDetail.getTotalEarnings();
            }
        }
        else if (componentType.toLowerCase().equals("deductions")) {
            for (SalaryDetail salaryDetail : salaryDetails) {
                sum += salaryDetail.getTotalDeductions();
            }
        }
    
        return sum;
    }

    public List<SalaryDetail> findAllByYearGroupByMonth(int year) throws Exception {
        String startDate = LocalDate.of(year, 1, 1).toString();
        String endDate = LocalDate.of(year, 12, 31).toString();

        List<SalaryAssignment> salaryAssignments = salaryAssignmentService.findAllByDate(startDate, endDate);

        // tsy miasa anaty calcul
        List<SalaryDetail> salDetailsForCol = getSalaryDetailFromAss(salaryAssignments, startDate,  endDate);
        List<String> longestColumns = getColumns(salDetailsForCol);

        List<SalaryDetail> newSalDetails = new ArrayList<>();
        for (int i=1; i<12; i++) {
            SalaryDetail d = new SalaryDetail();

            LocalDate date = LocalDate.of(year, i, 1);
            List<SalaryDetail> salDetails = findAllFilterByMonth(date);
            
            List<SalaryDetailDTO> salDetDTO = new ArrayList<>();
            for (String col : longestColumns) {
                salDetDTO.add(new SalaryDetailDTO(col));
            }
            d.setSalary_details(salDetDTO);
            d.setColumns(longestColumns);
            d.getSalaryAssignment().setFrom_date(date);

            for (SalaryDetail detail : salDetails) {
                // System.out.println(detail.getSalaryAssignment().getFrom_date());
                // System.out.println(detail.getSalary_details().get(0).getParent()+"\n");
                
                // System.out.println(detail.getSalaryAssignment());
                if (detail.getSalaryAssignment().getFrom_date().getMonthValue() == i) {
                    // System.out.println("ok "+i);
                    // System.out.println(detail.getSalaryAssignment().getBase());
                    d.getSalaryAssignment().setBase(d.getSalaryAssignment().getBase() + detail.getSalaryAssignment().getBase());

                //    System.err.println("Salary DTO components size: "+detail.getSalary_details().size());
                    for (int j = 0; j < detail.getSalary_details().size(); j++) {
                        try {
                            // System.out.println(j);
                            // System.out.println(detail.getSalary_details().get(j).getSalary_component());
                            // System.out.println(detail.getSalary_details().get(j).getParentfield());
                            d.getSalary_details().get(j).setParentfield(detail.getSalary_details().get(j).getParentfield());
                            d.getSalary_details().get(j).setAmount(d.getSalary_details().get(j).getAmount()+detail.getSalary_details().get(j).getAmount());
                        } catch (ArrayIndexOutOfBoundsException ae) {
                            d.getSalary_details().get(j).setAmount(d.getSalary_details().get(j).getAmount());
                        } catch (Exception e) {
                            e.printStackTrace();
                            throw new Exception(e);
                        }
                    }
                }
            }
            // System.out.println(d.getSalaryAssignment().getBase());

            d.setTotalParentField("earnings");
            d.setTotalParentField("deductions");
            newSalDetails.add(d);
        }
        return newSalDetails;
    }
    
    public List<SalaryDetail> findAllFilterByMonth(LocalDate date) throws Exception {
        YearMonth yearMonth = YearMonth.from(date);
        LocalDate lastDayOfMonth = yearMonth.atEndOfMonth();

        String startDate = date.withDayOfMonth(1).toString();
        String endDate = lastDayOfMonth.toString();

        List<SalaryAssignment> salaryAssignments = salaryAssignmentService.findAllByDate(startDate, endDate);
        
        List<SalaryDetail> salDetails = getSalaryDetailFromAss(salaryAssignments, startDate, endDate);
        for (SalaryDetail salaryDetail : salDetails) {
            salaryDetail.setTotalParentField("earnings");
            salaryDetail.setTotalParentField("deductions");
        }
        return salDetails;
    }

    private List<SalaryDetail> getSalaryDetailFromAss(List<SalaryAssignment> salaryAssignments, String startDate, String endDate) throws Exception {
        List<SalaryDetail> salDetails = new ArrayList<>();
        for (SalaryAssignment assignment : salaryAssignments) {
            Employe employee = employeService.findByEmployeeRef(assignment.getEmployee());
            List<SalarySlip> salarySlips = salarySlipService.findAllByDate(startDate, endDate, assignment.getEmployee());
            // System.out.println(startDate);
            // System.out.println(endDate);
            // System.out.println(assignment.getEmployee());
            // List<SalaryDetailDTO> salDetailsDTO = new ArrayList<>();
            // System.out.println("Salary Assgnment: "+assignment.getSalary_structure());
            // System.out.println("Employee: "+employee.getName());
            // System.out.println("Salary Details count: "+salDetailsDTO.size()+"\n");

            SalaryDetail salDetail = new SalaryDetail();
            salDetail.setEmploye(employee);
            salDetail.setSalaryAssignment(assignment);
            if (salarySlips.size() == 0) {
                salDetail.setSalary_details(findAllBySalStruct(assignment.getSalary_structure()));
            }
            else {
                salDetail.setSalary_details(findAllBySalStruct(salarySlips.get(0).getName()));
            } 
            salDetail.setColumns();
            salDetails.add(salDetail);
        }
        return salDetails;
    }
    
    public List<SalaryAssignment> findAllByDate(String startDate, String endDate) throws Exception {
        String url = "http://erpnext.localhost:8000/api/resource/Salary Structure Assignment?fields=[\"*\"]&filters=[[\"from_date\",\">=\",\"" + startDate + "\"], [\"from_date\",\"<=\",\"" + endDate + "\"]]&limit=500";
        
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "token "+ApiKeyService.getAPiKey());

        HttpEntity<Void> entity = new HttpEntity<>(headers);
        ResponseEntity<JsonNode> response = restTemplate.exchange(url, HttpMethod.GET, entity, JsonNode.class);

        JsonNode dataNode = response.getBody().get("data");
        SalaryAssignment[] rfqs = objectMapper.treeToValue(dataNode, SalaryAssignment[].class);

        return Arrays.asList(rfqs);
    }

    // public double[] sumPerYear(List<SalaryDetail> details) throws Exception {
    //     List<String> columns = getColumns(details);
    //     int longestSize = columns.size();

    //     double[] sum = new double[longestSize+1];
    //     double base = 0;

    //     for (SalaryDetail d : details) {
    //         base += d.getSalaryAssignment().getBase();
    //     }

    //     sum[0] = base;
    //     return sum;
    // }

    public double[] sum(List<SalaryDetail> details) throws Exception {
        List<String> columns = getColumns(details);
        int longestSize = columns.size();

        double[] sum = new double[longestSize+1];
        double base = 0;

        for (SalaryDetail d : details) {
            base += d.getSalaryAssignment().getBase();
            
            List<SalaryDetailDTO> salDTO = d.getSalary_details();
            for (int i=0; i<columns.size(); i++) {
                
                String col = columns.get(i);
                try {
                    SalaryDetailDTO sal = salDTO.get(i);
                    String component = sal.getSalary_component().toLowerCase();
                    if (col.toLowerCase().equals(component)) {
                        sum[i+1] += sal.getAmount();
                        // sum[i+1] = i+1;
                    }
                } catch (ArrayIndexOutOfBoundsException arrayEx) {
                    sum[i+1] += 0; // variable
                    // sum[i+1] = i+1;
                } catch (Exception ex) {
                    ex.printStackTrace();
                    throw new Exception(ex);
                }
            }
        }
        // sum[sum.length-1] = base;
        sum[0] = base;
        return sum;
    }

    public List<String> getColumns(List<SalaryDetail> details) {
        List<String> columns = new ArrayList<>();
        
        if (details.size() == 0) {
            return columns;
        }

        int id = getLongestSalComp(details);
        for (String col : details.get(id).getColumns()) {
            columns.add(col);
        }

        return columns;
    }
    
    public int getLongestSalComp(List<SalaryDetail> details) {
        int tabSize = 0;
        int longestIndex = 0;
        for (int i=0; i < details.size(); i++) {
            if (tabSize <= details.get(i).getColumns().size()) {
                longestIndex = i;
                tabSize = details.get(i).getColumns().size();
            }
        }

        return longestIndex;
    }

    public List<SalaryDetailDTO> findAllBySalStruct(String name) throws Exception {
        String url = "http://erpnext.localhost:8000/api/method/hrms.payroll.doctype.salary_detail.salary_detail.get_all?sal_struct="+name;
        
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "token "+ApiKeyService.getAPiKey());

        HttpEntity<Void> entity = new HttpEntity<>(headers);
        ResponseEntity<JsonNode> response = restTemplate.exchange(url, HttpMethod.GET, entity, JsonNode.class);

        JsonNode dataNode = response.getBody().get("message");
        SalaryDetailDTO[] rfqs = objectMapper.treeToValue(dataNode, SalaryDetailDTO[].class);

        return Arrays.asList(rfqs);
    }
    
    // can be `Salary Structure` or `Salary Slip`
    public List<SalaryDetailDTO> findAllByParType(String parentType) throws Exception {
        String url = "http://erpnext.localhost:8000/api/method/hrms.payroll.doctype.salary_detail.salary_detail.get_all_by_parenttype?par_type="+parentType;
        
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "token "+ApiKeyService.getAPiKey());

        HttpEntity<Void> entity = new HttpEntity<>(headers);
        ResponseEntity<JsonNode> response = restTemplate.exchange(url, HttpMethod.GET, entity, JsonNode.class);

        JsonNode dataNode = response.getBody().get("message");
        SalaryDetailDTO[] rfqs = objectMapper.treeToValue(dataNode, SalaryDetailDTO[].class);

        return Arrays.asList(rfqs);
    }

    public List<Double> exctractBase(List<SalaryDetail> salaryDetails) {
        List<Double> result = new ArrayList<>();
        for (SalaryDetail salDet : salaryDetails) {
            result.add(salDet.getSalaryAssignment().getBase());
        }
        return result;
    }

    public List<Double> extractCompTypeAmount(List<SalaryDetail> salaryDetails, String salCompType) {
        List<Double> result = new ArrayList<>();

        if (salCompType.equals("earnings")) {
            for (SalaryDetail salDet : salaryDetails) {
                result.add(salDet.getTotalEarnings());
            }
        }
        else if (salCompType.equals("deductions")) {
            for (SalaryDetail salDet : salaryDetails) {
                result.add(salDet.getTotalDeductions());
            }
        }
        return result;
    }
}




    // public List<SalaryDetail> findAllByYearGroupByMonth(int year) throws Exception {
    //     String startDate = LocalDate.of(year, 1, 1).toString();
    //     String endDate = LocalDate.of(year, 12, 31).toString();

    //     List<SalaryAssignment> salaryAssignments = salaryAssignmentService.findAllByDate(startDate, endDate);
    //     List<SalaryDetail> salDetails = getSalaryDetailFromAss(salaryAssignments, startDate,  endDate);
    //     List<String> longestColumns = getColumns(salDetails);

    //     List<SalaryDetail> newSalDetails = new ArrayList<>();
    //     for (int i=1; i<12; i++) {
    //         SalaryDetail d = new SalaryDetail();
            
    //         List<SalaryDetailDTO> salDetDTO = new ArrayList<>();
    //         for (String col : longestColumns) {
    //             salDetDTO.add(new SalaryDetailDTO(col));
    //         }
    //         d.setSalary_details(salDetDTO);
    //         d.setColumns(longestColumns);
    //         d.getSalaryAssignment().setFrom_date(LocalDate.of(year, i, 1));

    //         for (SalaryDetail detail : salDetails) {
    //             System.out.println(detail.getSalaryAssignment().getFrom_date());
    //             System.out.println(detail.getSalary_details().get(0).getParent()+"\n");

    //             if (detail.getSalaryAssignment().getFrom_date().getMonthValue() == i) {
    //                 d.getSalaryAssignment().setBase(d.getSalaryAssignment().getBase() + detail.getSalaryAssignment().getBase());

    //             //    System.err.println("Salary DTO components size: "+detail.getSalary_details().size());
    //                 for (int j = 0; j < detail.getSalary_details().size(); j++) {
    //                     try {
    //                         // System.out.println(j);
    //                         // System.out.println(detail.getSalary_details().get(j).getSalary_component());
    //                         // System.out.println(detail.getSalary_details().get(j).getParentfield());
    //                         d.getSalary_details().get(j).setParentfield(detail.getSalary_details().get(j).getParentfield());
    //                         d.getSalary_details().get(j).setAmount(d.getSalary_details().get(j).getAmount()+detail.getSalary_details().get(j).getAmount());
    //                     } catch (ArrayIndexOutOfBoundsException ae) {
    //                         d.getSalary_details().get(j).setAmount(d.getSalary_details().get(j).getAmount());
    //                     } catch (Exception e) {
    //                         e.printStackTrace();
    //                         throw new Exception(e);
    //                     }
    //                 }
    //             }
    //         }
    //         d.setTotalParentField("earnings");
    //         d.setTotalParentField("deductions");
    //         newSalDetails.add(d);
    //     }
    //     return newSalDetails;
    // }