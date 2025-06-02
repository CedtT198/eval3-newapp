package com.eval2.newapp.services;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.eval2.newapp.models.SalarySlip;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class SalarySlipService {
    
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ObjectMapper objectMapper;

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
