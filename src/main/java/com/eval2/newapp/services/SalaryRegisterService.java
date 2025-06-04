package com.eval2.newapp.services;

import java.net.URI;
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
import org.springframework.web.util.UriComponentsBuilder;
import com.eval2.newapp.models.SalaryRegister;
import com.eval2.newapp.models.SalaryRegisterColumns;
import com.eval2.newapp.models.SalaryRegisterResult;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class SalaryRegisterService {
    
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ObjectMapper objectMapper;

    // private List<List<Object>> combineSalRegResWithDynFields(List<SalaryRegisterResult> salRegRes) {
    //     List<List<Object>> combined = new ArrayList<>();

    //     for (SalaryRegisterResult res : salRegRes) {
    //         List<Object> object = new ArrayList<>();
    //         Map<String, Double> components = res.getSalary_components();

    //         combined.add(object);
    //     }

    //     return combined;
    // }


    public SalaryRegister findAllBetweenDate(String begin, String end) throws Exception {
        String filtersJson = String.format(
            "{\"from_date\":\"%s\",\"to_date\":\"%s\",\"currency\":\"EUR\",\"company\":\"Cedric Company\",\"docstatus\":\"Submitted\"}",
            begin, end
        );

        URI uri = UriComponentsBuilder.fromHttpUrl("http://erpnext.localhost:8000/api/method/frappe.desk.query_report.run")
            .queryParam("report_name", "Salary Register")
            .queryParam("filters", filtersJson)
            .queryParam("ignore_prepared_report", "false")
            .queryParam("are_default_filters", "false")
            .build()
            .encode()
            .toUri();
        
        // System.out.println(uri);
        // System.out.println(uri.toString());
            
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "token "+ApiKeyService.getAPiKey());
        headers.set("Content-Type", "application/json");
        headers.set("Accept", "application/json");

        HttpEntity<Void> entity = new HttpEntity<>(headers);
        ResponseEntity<JsonNode> response = restTemplate.exchange(uri, HttpMethod.GET, entity, JsonNode.class);
        
        JsonNode columnsJson = response.getBody().get("message").get("columns");
        List<SalaryRegisterColumns> columns = Arrays.asList(objectMapper.treeToValue(columnsJson, SalaryRegisterColumns[].class));
        
        JsonNode resultsJson = response.getBody().get("message").get("result");
        List<SalaryRegisterResult> results = new ArrayList<>();

        List<Object> total = new ArrayList<>();
        for (JsonNode node : resultsJson) {
            if (node.isObject()) {
                SalaryRegisterResult salaryRegisterResult = objectMapper.treeToValue(node, SalaryRegisterResult.class);
                results.add(salaryRegisterResult);
            }
            else if (node.isArray()) {
                for (Object object : node) {
                    total.add(object);
                }
            }
        }
        
        JsonNode messageBody = response.getBody().get("message");

        String message = objectMapper.treeToValue(messageBody.get("message"), String.class);
        String chart = objectMapper.treeToValue(messageBody.get("chart"), String.class);
        String report_summary = objectMapper.treeToValue(messageBody.get("report_summary"), String.class);
        int skip_total_row = objectMapper.treeToValue(messageBody.get("skip_total_row"), Integer.class);
        String status = objectMapper.treeToValue(messageBody.get("status"), String.class);
        double execution_time = objectMapper.treeToValue(messageBody.get("execution_time"), Double.class);
        boolean add_total_row = objectMapper.treeToValue(messageBody.get("add_total_row"), Boolean.class);

        SalaryRegister salaryRegister = new SalaryRegister();
        salaryRegister.setResults(results);
        salaryRegister.setTotal(total);
        salaryRegister.setColumns(columns);
        salaryRegister.setMessage(message);
        salaryRegister.setChart(chart);
        salaryRegister.setReport_summary(report_summary);
        salaryRegister.setSkip_total_row(skip_total_row);
        salaryRegister.setStatus(status);
        salaryRegister.setExecution_time(execution_time);
        salaryRegister.setAdd_total_row(add_total_row);

        return salaryRegister;
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
