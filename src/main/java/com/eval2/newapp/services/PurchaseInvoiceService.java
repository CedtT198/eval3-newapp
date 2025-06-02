package com.eval2.newapp.services;

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
import com.eval2.newapp.models.PurchaseInvoice;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PurchaseInvoiceService {
    
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ObjectMapper objectMapper;
    
    public void submit(String name, String docstatus, String status) throws Exception {
        String url = "http://erpnext.localhost:8000/api/resource/Purchase Invoice/" + name;
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "token "+ApiKeyService.getAPiKey());
 
        Map<String, Object> body = new HashMap<>();
        body.put("docstatus", docstatus);
        body.put("status", status);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(body, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.PUT, entity, String.class);
        
        System.out.println(response.getBody());
    }   

    public PurchaseInvoice find(String name) throws Exception {
        String url = "http://erpnext.localhost:8000/api/resource/Purchase Invoice?filters=[[\"name\",\"=\",\""+name+"\"]]&fields=[\"*\"]";
        
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "token "+ApiKeyService.getAPiKey());

        HttpEntity<Void> entity = new HttpEntity<>(headers);
        ResponseEntity<JsonNode> response = restTemplate.exchange(url, HttpMethod.GET, entity, JsonNode.class);

        JsonNode dataNode = response.getBody().get("data");
        PurchaseInvoice[] po = objectMapper.treeToValue(dataNode, PurchaseInvoice[].class);

        return Arrays.asList(po).get(0);
    }

    // public List<PurchaseInvoice> findBySupplierNameAndStatus(String supplierName, String status) throws Exception {
    //     String url = "http://erpnext.localhost:8000/api/resource/Purchase Invoice?filters=[[\"supplier_name\",\"=\",\""+supplierName+"\"],[\"status\",\"=\",\""+status+"\"]]&fields=[\"*\"]";
        
    //     HttpHeaders headers = new HttpHeaders();
    //     headers.set("Authorization", "token "+ApiKeyService.getAPiKey());

    //     HttpEntity<Void> entity = new HttpEntity<>(headers);
    //     ResponseEntity<JsonNode> response = restTemplate.exchange(url, HttpMethod.GET, entity, JsonNode.class);

    //     JsonNode dataNode = response.getBody().get("data");
    //     PurchaseInvoice[] po = objectMapper.treeToValue(dataNode, PurchaseInvoice[].class);

    //     return Arrays.asList(po);
    // }

    public List<PurchaseInvoice> findByStatus(String status) throws Exception {
        String url = "http://erpnext.localhost:8000/api/resource/Purchase Invoice?filters=[[\"status\",\"=\",\""+status+"\"]]&fields=[\"*\"]";
        
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "token "+ApiKeyService.getAPiKey());

        HttpEntity<Void> entity = new HttpEntity<>(headers);
        ResponseEntity<JsonNode> response = restTemplate.exchange(url, HttpMethod.GET, entity, JsonNode.class);

        JsonNode dataNode = response.getBody().get("data");
        PurchaseInvoice[] po = objectMapper.treeToValue(dataNode, PurchaseInvoice[].class);

        return Arrays.asList(po);
    }
    
    // public List<PurchaseInvoice> findBySupplierName(String supplierName) throws Exception {
    //     String url = "http://erpnext.localhost:8000/api/resource/Purchase Invoice?filters=[[\"supplier_name\",\"=\",\""+supplierName+"\"]]&fields=[\"*\"]";
        
    //     HttpHeaders headers = new HttpHeaders();
    //     headers.set("Authorization", "token "+ApiKeyService.getAPiKey());

    //     HttpEntity<Void> entity = new HttpEntity<>(headers);
    //     ResponseEntity<JsonNode> response = restTemplate.exchange(url, HttpMethod.GET, entity, JsonNode.class);

    //     JsonNode dataNode = response.getBody().get("data");
    //     PurchaseInvoice[] po = objectMapper.treeToValue(dataNode, PurchaseInvoice[].class);

    //     return Arrays.asList(po);
    // }

    public List<PurchaseInvoice> findAll() throws Exception {
        String url = "http://erpnext.localhost:8000/api/resource/Purchase Invoice?fields=[\"*\"]";
        
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "token "+ApiKeyService.getAPiKey());

        HttpEntity<Void> entity = new HttpEntity<>(headers);
        ResponseEntity<JsonNode> response = restTemplate.exchange(url, HttpMethod.GET, entity, JsonNode.class);

        JsonNode dataNode = response.getBody().get("data");
        PurchaseInvoice[] po = objectMapper.treeToValue(dataNode, PurchaseInvoice[].class);

        return Arrays.asList(po);
    }
}
