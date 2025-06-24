package com.eval2.newapp.services;

import java.time.LocalDate;
import java.time.YearMonth;
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
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class SalaryAssignmentService {
    
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ObjectMapper objectMapper;

    public int updateMultipleSalaryAssignment(List<SalaryAssignment> salaryAssignments, double amount) throws Exception{
        for (SalaryAssignment salaryAssignment : salaryAssignments) {
            update(salaryAssignment, amount);
            System.out.println(salaryAssignment.getName());
        }
        return salaryAssignments.size();
    }

    public void update(SalaryAssignment salaryAssignment, double amount) throws Exception {
        updateStatus(salaryAssignment.getName(), 2);
        save(salaryAssignment.getFrom_date(), salaryAssignment.getEmployee(), amount, salaryAssignment.getSalary_structure());
    }

    public void updateStatus(String name, int docstatus) throws Exception {
        String url = "http://erpnext.localhost:8000/api/resource/Salary Structure Assignment/" + name;
        
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

    public void save(LocalDate startDate, String empRef, double amount, String salaryStructure) throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "token "+ApiKeyService.getAPiKey());

        HttpEntity<Void> entity = new HttpEntity<>(headers);

        String url = "http://erpnext.localhost:8000/api/method/hrms.payroll.doctype.salary_structure_assignment.salary_structure_assignment.create_salary_assignment?employee_ref="+empRef+"&from_date="+startDate.toString()+"&base="+amount+"&salary_structure="+salaryStructure;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);

        System.out.println(response.getBody());
    }

    public List<SalaryAssignment> findLastBefore(String date, String empRef) throws Exception {
        String url = "http://erpnext.localhost:8000/api/resource/Salary Structure Assignment?fields=[\"*\"]&filters=[[\"from_date\",\"<=\",\""+date+"\"], [\"employee\",\"=\",\""+empRef+"\"]]&order_by=from_date desc&limit=1";
        
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "token "+ApiKeyService.getAPiKey());

        HttpEntity<Void> entity = new HttpEntity<>(headers);
        ResponseEntity<JsonNode> response = restTemplate.exchange(url, HttpMethod.GET, entity, JsonNode.class);

        JsonNode dataNode = response.getBody().get("data");
        SalaryAssignment[] rfqs = objectMapper.treeToValue(dataNode, SalaryAssignment[].class);

        return Arrays.asList(rfqs);
    }
    
    public List<SalaryAssignment> findLastBefore(String date) throws Exception {
        String url = "http://erpnext.localhost:8000/api/resource/Salary Structure Assignment?fields=[\"from_date\"]&filters=[[\"from_date\",\"<=\",\""+date+"\"]]&order_by=from_date desc&limit=1";
        
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "token "+ApiKeyService.getAPiKey());

        HttpEntity<Void> entity = new HttpEntity<>(headers);
        ResponseEntity<JsonNode> response = restTemplate.exchange(url, HttpMethod.GET, entity, JsonNode.class);

        JsonNode dataNode = response.getBody().get("data");
        SalaryAssignment[] rfqs = objectMapper.treeToValue(dataNode, SalaryAssignment[].class);

        return Arrays.asList(rfqs);
    }


    public List<SalaryAssignment> findAllByDate(String startDate, String endDate) throws Exception {
        String url = "http://erpnext.localhost:8000/api/resource/Salary Structure Assignment?fields=[\"*\"]&filters=[[\"from_date\",\">=\",\"" + startDate + "\"], [\"from_date\",\"<=\",\"" + endDate + "\"]]&limit=500";
        
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "token "+ApiKeyService.getAPiKey());

        HttpEntity<Void> entity = new HttpEntity<>(headers);
        ResponseEntity<JsonNode> response = restTemplate.exchange(url, HttpMethod.GET, entity, JsonNode.class);

        JsonNode dataNode = response.getBody().get("data");
        System.out.println("Salary Structure Assignment :\n"+dataNode.toString());
        SalaryAssignment[] rfqs = objectMapper.treeToValue(dataNode, SalaryAssignment[].class);

        return Arrays.asList(rfqs);
    }

    public List<SalaryAssignment> findAllByEmp(String empRef, LocalDate date) throws Exception {
        YearMonth yearMonth = YearMonth.from(date);
        LocalDate lastDayOfMonth = yearMonth.atEndOfMonth();

        String startDate = date.withDayOfMonth(1).toString();
        String endDate = lastDayOfMonth.toString();
        String url = "http://erpnext.localhost:8000/api/resource/Salary Structure Assignment?fields=[\"*\"]&filters=[[\"employee\",\"=\",\"" + empRef + "\"], [\"docstatus\",\"=\",\"1\"], [\"from_date\",\">=\",\"" + startDate + "\"], [\"from_date\",\"<=\",\"" + endDate + "\"]]&limit=500";
        
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "token "+ApiKeyService.getAPiKey());

        HttpEntity<Void> entity = new HttpEntity<>(headers);
        ResponseEntity<JsonNode> response = restTemplate.exchange(url, HttpMethod.GET, entity, JsonNode.class);

        JsonNode dataNode = response.getBody().get("data");
        SalaryAssignment[] rfqs = objectMapper.treeToValue(dataNode, SalaryAssignment[].class);

        return Arrays.asList(rfqs);
    }

    public List<SalaryAssignment> findAllByEmp(String empRef) throws Exception {
        // All
        // String url = "http://erpnext.localhost:8000/api/resource/Salary Structure Assignment?fields=[\"*\"]&filters=[[\"employee\",\"=\",\"" + empRef + "\"], [\"docstatus\",\"=\",\"1\"]]"; 
        // Par mois
        String url = "http://erpnext.localhost:8000/api/resource/Salary Structure Assignment?fields=[\"*\"]&filters=[[\"employee\",\"=\",\"" + empRef + "\"], [\"docstatus\",\"=\",\"1\"]]&limit=500";
        
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "token "+ApiKeyService.getAPiKey());

        HttpEntity<Void> entity = new HttpEntity<>(headers);
        ResponseEntity<JsonNode> response = restTemplate.exchange(url, HttpMethod.GET, entity, JsonNode.class);

        JsonNode dataNode = response.getBody().get("data");
        SalaryAssignment[] rfqs = objectMapper.treeToValue(dataNode, SalaryAssignment[].class);

        return Arrays.asList(rfqs);
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
    
    // public List<Employe> findAll() throws Exception {
    //     String url = "http://erpnext.localhost:8000/api/resource/Employee?fields=[\"*\"]";
        
    //     HttpHeaders headers = new HttpHeaders();
    //     headers.set("Authorization", "token "+ApiKeyService.getAPiKey());

    //     HttpEntity<Void> entity = new HttpEntity<>(headers);
    //     ResponseEntity<JsonNode> response = restTemplate.exchange(url, HttpMethod.GET, entity, JsonNode.class);

    //     JsonNode dataNode = response.getBody().get("data");
    //     Employe[] rfqs = objectMapper.treeToValue(dataNode, Employe[].class);

    //     return Arrays.asList(rfqs);
    // }
}
