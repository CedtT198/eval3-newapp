package com.eval2.newapp.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.eval2.newapp.models.SalaryAssignment;
import com.eval2.newapp.models.SalaryDetailDTO;
import com.eval2.newapp.models.SalarySlip;
import com.eval2.newapp.models.SalaryStructure;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class SalarySlipService {
    
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private DateService dateService;
    @Autowired
    private SalaryAssignmentService salaryAssignmentService;
    
    public int[] updateSalary(List<SalarySlip> salarySlips, double amount) throws Exception {
        List<SalaryAssignment> salaryAssignments = new ArrayList<>();

        // take distinctly all salary structure assignment
        for (SalarySlip salarySlip : salarySlips) {
            boolean exist = false;
            SalaryAssignment salaryAssignment = salaryAssignmentService.findLastBefore(salarySlip.getStart_date().toString(), salarySlip.getEmployee()).get(0);

            for (SalaryAssignment salAss : salaryAssignments) {
                if (salaryAssignment.getName().equals(salAss.getName())) {
                    exist = true;
                    break;
                }
            }

            if (!exist) salaryAssignments.add(salaryAssignment);
        }
        int assignment_record = salaryAssignmentService.updateMultipleSalaryAssignment(salaryAssignments, amount);
        int slip_record = updateMultipleSalarySlip(salarySlips, amount);
        
        int[] records = new int[]{assignment_record, slip_record};
        return records;
    }

    public int updateMultipleSalarySlip(List<SalarySlip> salarySlips, double amount) throws Exception{
        for (SalarySlip salarySlip : salarySlips) {
            update(salarySlip, amount);
        }
        return salarySlips.size();
    }
    
    public void update(SalarySlip salarySlip, double amount) throws Exception {
        updateStatus(salarySlip.getName(), 2);
        save(salarySlip.getStart_date(), salarySlip.getEmployee(), amount, salarySlip.getSalary_structure());
    }
    
    public void updateStatus(String name, int docstatus) throws Exception {
        String url = "http://erpnext.localhost:8000/api/resource/Salary Slip/" + name;
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "token "+ApiKeyService.getAPiKey());
 
        Map<String, Object> body = new HashMap<>();
        body.put("docstatus", docstatus);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(body, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.PUT, entity, String.class);
        
        System.out.println(response.getBody());
    }   

    public int generate(LocalDate startDate, LocalDate endDate, String empRef, double amount, SalaryStructure salaryStructure) throws Exception {
        int record = 0;
        long monthsBetween = dateService.getMonthBetween(startDate, endDate);
        System.out.println("Months in between : "+monthsBetween);
        for (int i = 0; i < monthsBetween; i++) {
            System.out.println(startDate);
            System.out.println(empRef);
            System.out.println(amount);
            System.out.println(salaryStructure+"\n");
            record += save(startDate, empRef, amount, salaryStructure.getName());
            startDate = startDate.plusMonths(1);
        }
        return record; // returned as insertion record.
    }
    
    public int generateWithAssignment(LocalDate startDate, LocalDate endDate, String empRef, Double amount, SalaryStructure salaryStructure)  throws Exception {
        int record = 0;
        long monthsBetween = dateService.getMonthBetween(startDate, endDate);
        System.out.println("Months in between : "+monthsBetween);
        for (int i = 0; i < monthsBetween; i++) {
            System.out.println(startDate);
            System.out.println(empRef);
            System.out.println(amount+"\n");
            salaryAssignmentService.save(startDate, empRef, amount, salaryStructure.getName());
            record += save(startDate, empRef, amount, salaryStructure.getName());
            startDate = startDate.plusMonths(1);
        }
        return record; // returned as insertion record.
    }

    public int save(LocalDate date, String empRef, double amount, String salaryStructure) throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "token "+ApiKeyService.getAPiKey());

        HttpEntity<Void> entity = new HttpEntity<>(headers);

        String url = "http://erpnext.localhost:8000/api/method/hrms.payroll.doctype.salary_slip.salary_slip.create_salary_slip?employee_ref="+empRef+"&salary_structure="+salaryStructure+"&start_date="+date+"&base="+amount;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<JsonNode> response = restTemplate.postForEntity(url, entity, JsonNode.class);

        System.out.println(response.getBody());
        JsonNode dataNode = response.getBody().get("message");
        int message = objectMapper.treeToValue(dataNode, Integer.class);
        return message;
    }

    public SalarySlip save(SalarySlip salary_slip) throws Exception {
        String json = objectMapper.writeValueAsString(salary_slip);
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "token "+ApiKeyService.getAPiKey());

        HttpEntity<String> entity = new HttpEntity<>(json, headers);

        String url = "http://erpnext.localhost:8000/api/resource/Salary Slip";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);

        System.out.println(response.getBody());
        return salary_slip;
    }
    
    public List<SalarySlip> findAllByDate(String startDate, String endDate, String emp) throws Exception {
        String url = "http://erpnext.localhost:8000/api/resource/Salary Slip?fields=[\"*\"]&filters=[[\"posting_date\",\">=\",\"" + startDate + "\"], [\"posting_date\",\"<=\",\"" + endDate + "\"], [\"employee\",\"=\",\"" + emp + "\"]]&limit=500";
        // System.out.println(url);
        
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "token "+ApiKeyService.getAPiKey());

        HttpEntity<Void> entity = new HttpEntity<>(headers);
        ResponseEntity<JsonNode> response = restTemplate.exchange(url, HttpMethod.GET, entity, JsonNode.class);

        JsonNode dataNode = response.getBody().get("data");
        System.out.println(dataNode.toString());
        SalarySlip[] rfqs = objectMapper.treeToValue(dataNode, SalarySlip[].class);

        return Arrays.asList(rfqs);
    }

    public SalarySlip findByName(String name) throws Exception {
        String url = "http://erpnext.localhost:8000/api/resource/Salary Slip?fields=[\"*\"]&filters=[[\"name\",\"=\",\"" + name + "\"]]";
        
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "token "+ApiKeyService.getAPiKey());

        HttpEntity<Void> entity = new HttpEntity<>(headers);
        ResponseEntity<JsonNode> response = restTemplate.exchange(url, HttpMethod.GET, entity, JsonNode.class);

        JsonNode dataNode = response.getBody().get("data");
        SalarySlip[] rfqs = objectMapper.treeToValue(dataNode, SalarySlip[].class);

        return Arrays.asList(rfqs).get(0);
    }

    // public List<SalaryAssignment> findByName(String nameLike) throws Exception {
    //     String url = "http://erpnext.localhost:8000/api/resource/Employee?fields=[\"*\"]&filters=[[\"employee_name\",\"like\",\"%" + nameLike + "%\"]]";
        
    //     HttpHeaders headers = new HttpHeaders();
    //     headers.set("Authorization", "token "+ApiKeyService.getAPiKey());

    //     HttpEntity<Void> entity = new HttpEntity<>(headers);
    //     ResponseEntity<JsonNode> response = restTemplate.exchange(url, HttpMethod.GET, entity, JsonNode.class);

    //     JsonNode dataNode = response.getBody().get("data");
    //     SalaryAssignment[] rfqs = objectMapper.treeToValue(dataNode, SalaryAssignment[].class);

    //     return Arrays.asList(rfqs);
    // }
    
    public List<SalarySlip> findAll() throws Exception {
        String url = "http://erpnext.localhost:8000/api/resource/Salary Slip?fields=[\"*\"]";
        
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "token "+ApiKeyService.getAPiKey());

        HttpEntity<Void> entity = new HttpEntity<>(headers);
        ResponseEntity<JsonNode> response = restTemplate.exchange(url, HttpMethod.GET, entity, JsonNode.class);

        JsonNode dataNode = response.getBody().get("data");
        SalarySlip[] rfqs = objectMapper.treeToValue(dataNode, SalarySlip[].class);

        return Arrays.asList(rfqs);
    }

    public List<SalarySlip> findSalarySlipFromDetails(List<SalaryDetailDTO> salaryDetailDTO) throws Exception {
        List<SalarySlip> salarySlips = new ArrayList<>();
        
        for (SalaryDetailDTO salaryDetail : salaryDetailDTO) {
            SalarySlip salarySlip = findByName(salaryDetail.getParent());

            System.out.println(salarySlip.getName());
            System.out.println(salarySlip.getStart_date());
            System.out.println(salarySlip.getEmployee()+"\n");

            // System.out.println(salaryDetail.getParent());
            // System.out.println(salaryDetail.getName());
            // System.out.println(salaryDetail.getSalary_component());
            // System.out.println(salaryDetail.getAmount()+"\n");

            salarySlips.add(salarySlip);
        }

        return salarySlips;
    }
}
