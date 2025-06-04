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
import com.eval2.newapp.models.Employe;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class EmployeService {
    
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ObjectMapper objectMapper;

    
    public Employe findByEmployeeRef(String name) throws Exception {
        String url = "http://erpnext.localhost:8000/api/resource/Employee?fields=[\"*\"]&filters=[[\"employee\",\"=\",\"" + name + "\"]]";
        
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "token "+ApiKeyService.getAPiKey());

        HttpEntity<Void> entity = new HttpEntity<>(headers);
        ResponseEntity<JsonNode> response = restTemplate.exchange(url, HttpMethod.GET, entity, JsonNode.class);

        JsonNode dataNode = response.getBody().get("data");
        Employe[] rfqs = objectMapper.treeToValue(dataNode, Employe[].class);

        return Arrays.asList(rfqs).get(0);
    }

    public List<Employe> findByName(String nameLike) throws Exception {
        String url = "http://erpnext.localhost:8000/api/resource/Employee?fields=[\"*\"]&filters=[[\"employee_name\",\"like\",\"%" + nameLike + "%\"]]";
        
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "token "+ApiKeyService.getAPiKey());

        HttpEntity<Void> entity = new HttpEntity<>(headers);
        ResponseEntity<JsonNode> response = restTemplate.exchange(url, HttpMethod.GET, entity, JsonNode.class);

        JsonNode dataNode = response.getBody().get("data");
        Employe[] rfqs = objectMapper.treeToValue(dataNode, Employe[].class);

        return Arrays.asList(rfqs);
    }
    
    public List<Employe> findAll() throws Exception {
        String url = "http://erpnext.localhost:8000/api/resource/Employee?fields=[\"*\"]";
        
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "token "+ApiKeyService.getAPiKey());

        HttpEntity<Void> entity = new HttpEntity<>(headers);
        ResponseEntity<JsonNode> response = restTemplate.exchange(url, HttpMethod.GET, entity, JsonNode.class);

        JsonNode dataNode = response.getBody().get("data");
        Employe[] rfqs = objectMapper.treeToValue(dataNode, Employe[].class);

        return Arrays.asList(rfqs);
    }
}
