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
import com.eval2.newapp.models.PurchaseOrder;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PurchaseOrderService {
    
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ObjectMapper objectMapper;
    
    public List<PurchaseOrder> findBySupplierNameAndStatus(String supplierName, String status) throws Exception {
        String url = "http://erpnext.localhost:8000/api/resource/Purchase Order?filters=[[\"supplier_name\",\"=\",\""+supplierName+"\"],[\"status\",\"=\",\""+status+"\"]]&fields=[\"*\"]";
        
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "token "+ApiKeyService.getAPiKey());

        HttpEntity<Void> entity = new HttpEntity<>(headers);
        ResponseEntity<JsonNode> response = restTemplate.exchange(url, HttpMethod.GET, entity, JsonNode.class);

        JsonNode dataNode = response.getBody().get("data");
        PurchaseOrder[] po = objectMapper.treeToValue(dataNode, PurchaseOrder[].class);

        return Arrays.asList(po);
    }

    public List<PurchaseOrder> findByStatus(String status) throws Exception {
        String url = "http://erpnext.localhost:8000/api/resource/Purchase Order?filters=[[\"status\",\"=\",\""+status+"\"]]&fields=[\"*\"]";
        
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "token "+ApiKeyService.getAPiKey());

        HttpEntity<Void> entity = new HttpEntity<>(headers);
        ResponseEntity<JsonNode> response = restTemplate.exchange(url, HttpMethod.GET, entity, JsonNode.class);

        JsonNode dataNode = response.getBody().get("data");
        PurchaseOrder[] po = objectMapper.treeToValue(dataNode, PurchaseOrder[].class);

        return Arrays.asList(po);
    }

    public List<PurchaseOrder> findBySupplierName(String supplierName) throws Exception {
        String url = "http://erpnext.localhost:8000/api/resource/Purchase Order?filters=[[\"supplier_name\",\"=\",\""+supplierName+"\"]]&fields=[\"*\"]";
        
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "token "+ApiKeyService.getAPiKey());

        HttpEntity<Void> entity = new HttpEntity<>(headers);
        ResponseEntity<JsonNode> response = restTemplate.exchange(url, HttpMethod.GET, entity, JsonNode.class);

        JsonNode dataNode = response.getBody().get("data");
        PurchaseOrder[] po = objectMapper.treeToValue(dataNode, PurchaseOrder[].class);

        return Arrays.asList(po);
    }

    public List<PurchaseOrder> findAll() throws Exception {
        String url = "http://erpnext.localhost:8000/api/resource/Purchase Order?fields=[\"*\"]";
        
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "token "+ApiKeyService.getAPiKey());

        HttpEntity<Void> entity = new HttpEntity<>(headers);
        ResponseEntity<JsonNode> response = restTemplate.exchange(url, HttpMethod.GET, entity, JsonNode.class);

        JsonNode dataNode = response.getBody().get("data");
        PurchaseOrder[] po = objectMapper.treeToValue(dataNode, PurchaseOrder[].class);

        return Arrays.asList(po);
    }
}
