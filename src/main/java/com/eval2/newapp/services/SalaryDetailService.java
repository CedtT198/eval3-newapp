package com.eval2.newapp.services;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
    private SalaryAssignmentService salaryAssignmentService;

    public List<SalaryDetail> findAllByYearGroupByMonth(int year) throws Exception {
        String startDate = LocalDate.of(year, 1, 1).toString();
        String endDate = LocalDate.of(year, 12, 31).toString();

        List<SalaryAssignment> salaryAssignments = salaryAssignmentService.findAllByDate(startDate, endDate);
        List<SalaryDetail> salDetails = getSalaryDetailFromAss(salaryAssignments);
        List<String> longestColumns = getColumns(salDetails);
        System.err.println("Longest column size: "+longestColumns.size());

        List<SalaryDetail> newSalDetails = new ArrayList<>();
        for (int i=1; i<12; i++) {
            SalaryDetail d = new SalaryDetail();
            
            List<SalaryDetailDTO> salDetDTO = new ArrayList<>();
            for (String col : longestColumns) {
                salDetDTO.add(new SalaryDetailDTO(col));
            }
            d.setSalary_details(salDetDTO);
            d.setColumns(longestColumns);
            d.getSalaryAssignment().setFrom_date(LocalDate.of(year, i, 1));

            for (SalaryDetail detail : salDetails) {
                if (detail.getSalaryAssignment().getFrom_date().getMonthValue() == i) {
                    d.getSalaryAssignment().setBase(d.getSalaryAssignment().getBase() + detail.getSalaryAssignment().getBase());

                   System.err.println("Salary DTO components size: "+detail.getSalary_details().size());
                    for (int j = 0; j < detail.getSalary_details().size(); j++) {
                        try {
                            System.out.println(j);
                            System.out.println(detail.getSalary_details().get(j).getSalary_component());
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
        
        List<SalaryDetail> salDetails = getSalaryDetailFromAss(salaryAssignments);
        return salDetails;
    }

    // public void set

    private List<SalaryDetail> getSalaryDetailFromAss(List<SalaryAssignment> salaryAssignments) throws Exception {
        List<SalaryDetail> salDetails = new ArrayList<>();
        for (SalaryAssignment assignment : salaryAssignments) {
            Employe employee = employeService.findByEmployeeRef(assignment.getEmployee());
            List<SalaryDetailDTO> salDetailsDTO = findAllBySalStruct(assignment.getSalary_structure());
            System.out.println("Salary Assgnment: "+assignment.getSalary_structure());
            System.out.println("Employee: "+employee.getName());
            System.out.println("Salary Details count: "+salDetailsDTO.size()+"\n");

            SalaryDetail salDetail = new SalaryDetail();
            salDetail.setEmploye(employee);
            salDetail.setSalaryAssignment(assignment);
            salDetail.setSalary_details(salDetailsDTO);
            salDetail.setColumns();

            salDetails.add(salDetail);
        }
        return salDetails;
    }

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
                        sum[i] += sal.getAmount();
                        // sum[i+1] = i+1;
                    }
                } catch (ArrayIndexOutOfBoundsException arrayEx) {
                    sum[i] += 0; // variable
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
}
