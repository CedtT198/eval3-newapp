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

import com.eval2.newapp.models.Item;
import com.eval2.newapp.models.SupplierQuotation;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class SupplierQuotationService {
    
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ObjectMapper objectMapper;

    
    // public SupplierQuotation saveItem(Item item) throws Exception {
    //     ObjectMapper mapper = new ObjectMapper();
    //     String json = mapper.writeValueAsString(item);
        
    //     HttpHeaders headers = new HttpHeaders();
    //     headers.setContentType(MediaType.APPLICATION_JSON);
    //     headers.set("Authorization", "token "+ApiKeyService.getAPiKey());

    //     HttpEntity<String> entity = new HttpEntity<>(json, headers);

    //     String url = "http://erpnext.localhost:8000/api/resource/Supplier Quotation Item";
    //     RestTemplate restTemplate = new RestTemplate();
    //     ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);

    //     System.out.println(response.getBody());
    //     return supplier_quotation;
    // }


    public SupplierQuotation save(SupplierQuotation supplier_quotation) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(supplier_quotation);
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "token "+ApiKeyService.getAPiKey());

        HttpEntity<String> entity = new HttpEntity<>(json, headers);

        String url = "http://erpnext.localhost:8000/api/resource/Supplier Quotation";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);

        System.out.println(response.getBody());
        return supplier_quotation;
    }

    
    public List<SupplierQuotation> findBySupplierName(String supplierName) throws Exception {
        String url = "http://erpnext.localhost:8000/api/resource/Supplier Quotation?filters=[[\"supplier_name\",\"=\",\""+supplierName+"\"]]&fields=[\"*\"]";
        
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "token "+ApiKeyService.getAPiKey());

        HttpEntity<Void> entity = new HttpEntity<>(headers);
        ResponseEntity<JsonNode> response = restTemplate.exchange(url, HttpMethod.GET, entity, JsonNode.class);

        JsonNode dataNode = response.getBody().get("data");
        SupplierQuotation[] rfqs = objectMapper.treeToValue(dataNode, SupplierQuotation[].class);

        return Arrays.asList(rfqs);
    }

    public List<SupplierQuotation> findAll() throws Exception {
        String url = "http://erpnext.localhost:8000/api/resource/Supplier Quotation?fields=[\"*\"]";
        
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "token "+ApiKeyService.getAPiKey());

        HttpEntity<Void> entity = new HttpEntity<>(headers);
        ResponseEntity<JsonNode> response = restTemplate.exchange(url, HttpMethod.GET, entity, JsonNode.class);

        JsonNode dataNode = response.getBody().get("data");
        SupplierQuotation[] rfqs = objectMapper.treeToValue(dataNode, SupplierQuotation[].class);

        return Arrays.asList(rfqs);
    }
}
