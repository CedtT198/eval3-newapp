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
import com.eval2.newapp.models.RequestForQuotation;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ItemService {
    
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ObjectMapper objectMapper;

    public double getSumAmount(List<Item> items) {
        double sum = 0;
        for (Item item : items) {
            sum += item.getAmount();
        }
        return sum;
    }

    public double getSumQty(List<Item> items) {
        double sum = 0;
        for (Item item : items) {
            sum += item.getQty();
        }
        return sum;
    }

    public void updateStatus(String name, int docstatus, String status) throws Exception {
        String url = "http://erpnext.localhost:8000/api/resource/Supplier Quotation/" + name;
        
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


    public void updatePrice(String supplierQuotationName, String itemCode, double rate, double quantity) throws Exception {
        String url = "http://erpnext.localhost:8000/api/resource/Supplier Quotation/" + supplierQuotationName;
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "token "+ApiKeyService.getAPiKey());

        List<Item> items = findAll(supplierQuotationName);
        List<Item> itemsUpdated = getListUpdated(items, itemCode, rate, quantity);
    
        Map<String, Object> body = new HashMap<>();
        body.put("items", itemsUpdated);
        body.put("docstatus", "1");
        body.put("status", "Submitted");

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(body, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.PUT, entity, String.class);
        
        System.out.println(response.getBody());
    }   

    private List<Item> getListUpdated(List<Item> items, String itemCode, double rate, double quantity) {
        for (Item item : items) {
            if (item.getItem_code().equals(itemCode)) {
                item.setRate(rate);
                item.setQty(quantity);
            }
        }
        return items;
    }

    public List<Item> findAll(String supplierQuotationName) throws Exception {
        String url = "http://erpnext.localhost:8000/api/resource/Supplier Quotation/"+supplierQuotationName;
        
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "token "+ApiKeyService.getAPiKey());

        HttpEntity<Void> entity = new HttpEntity<>(headers);
        ResponseEntity<JsonNode> response = restTemplate.exchange(url, HttpMethod.GET, entity, JsonNode.class);
        
        JsonNode dataNode = response.getBody().get("data").get("items");
        System.out.println(dataNode);
    
        Item[] items = objectMapper.treeToValue(dataNode, Item[].class);
        return Arrays.asList(items);
    }
    
    public List<Item> findAll() throws Exception {
        String url = "http://erpnext.localhost:8000/api/resource/Item?fields=[\"*\"]";
        
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "token "+ApiKeyService.getAPiKey());
        // headers.setBasicAuth("Administrator", "cedric");

        HttpEntity<Void> entity = new HttpEntity<>(headers);
        ResponseEntity<JsonNode> response = restTemplate.exchange(url, HttpMethod.GET, entity, JsonNode.class);

        JsonNode dataNode = response.getBody().get("data");
        Item[] rfqs = objectMapper.treeToValue(dataNode, Item[].class);

        return Arrays.asList(rfqs);
    }
}
