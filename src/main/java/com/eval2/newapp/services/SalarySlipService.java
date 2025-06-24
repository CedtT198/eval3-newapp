package com.eval2.newapp.services;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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

    public int generate(LocalDate startDate, LocalDate endDate, String empRef, double amount, SalaryStructure salaryStructure) throws Exception {
        int record = 0;
        long monthsBetween = dateService.getMonthBetween(startDate, endDate);
        System.out.println("Months in between : "+monthsBetween);
        for (int i = 0; i < monthsBetween; i++) {
            System.out.println(startDate);
            System.out.println(empRef);
            System.out.println(amount);
            System.out.println(salaryStructure+"\n");
            record += save(startDate, empRef, amount, salaryStructure);
            startDate = startDate.plusMonths(1);
        }
        return record; // returned as insertion record.
    }

    public int save(LocalDate date, String empRef, double amount, SalaryStructure salaryStructure) throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "token "+ApiKeyService.getAPiKey());

        HttpEntity<Void> entity = new HttpEntity<>(headers);

        String url = "http://erpnext.localhost:8000/api/method/hrms.payroll.doctype.salary_slip.salary_slip.create_salary_slip?employee_ref="+empRef+"&salary_structure="+salaryStructure.getName()+"&start_date="+date+"&base="+amount;
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

    public List<SalarySlip> findAllByEmp(String name) throws Exception {
        String url = "http://erpnext.localhost:8000/api/resource/Salary Slip?fields=[\"*\"]&filters=[[\"name\",\"=\",\"" + name + "\"]]";
        
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "token "+ApiKeyService.getAPiKey());

        HttpEntity<Void> entity = new HttpEntity<>(headers);
        ResponseEntity<JsonNode> response = restTemplate.exchange(url, HttpMethod.GET, entity, JsonNode.class);

        JsonNode dataNode = response.getBody().get("data");
        SalarySlip[] rfqs = objectMapper.treeToValue(dataNode, SalarySlip[].class);

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
}
