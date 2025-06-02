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
import com.eval2.newapp.models.Payment;
import com.eval2.newapp.models.PaymentEntryReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PaymentService {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ObjectMapper objectMapper;

    // public Payment cancel(Payment payment) throws Exception {
    //     payment.setStatus("Cancelled");
    //     payment.setDocstatus(2);
    //     String url = "http://erpnext.localhost:8000/api/resource/Payment Entry/" + payment.getName();
        
    //     HttpHeaders headers = new HttpHeaders();
    //     headers.setContentType(MediaType.APPLICATION_JSON);
    //     headers.set("Authorization", "token "+ApiKeyService.getAPiKey());
 
    //     Map<String, Object> body = new HashMap<>();
    //     body.put("docstatus", payment.getDocstatus());
    //     body.put("status", payment.getStatus());

    //     HttpEntity<Map<String, Object>> entity = new HttpEntity<>(body, headers);

    //     RestTemplate restTemplate = new RestTemplate();
    //     ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.PUT, entity, String.class);
        
    //     System.out.println(response.getBody());
    //     return payment;
    // }   

    // public Payment submit(Payment payment) throws Exception {
    //     payment.setStatus("Submitted");
    //     payment.setDocstatus(1);
    //     String url = "http://erpnext.localhost:8000/api/resource/Payment Entry/" + payment.getName();
        
    //     HttpHeaders headers = new HttpHeaders();
    //     headers.setContentType(MediaType.APPLICATION_JSON);
    //     headers.set("Authorization", "token "+ApiKeyService.getAPiKey());
 
    //     Map<String, Object> body = new HashMap<>();
    //     body.put("docstatus", payment.getDocstatus());
    //     body.put("status", payment.getStatus());

    //     HttpEntity<Map<String, Object>> entity = new HttpEntity<>(body, headers);

    //     RestTemplate restTemplate = new RestTemplate();
    //     ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.PUT, entity, String.class);
        
    //     System.out.println(response.getBody());
    //     return payment;
    // }   
    
    public Payment find(String name) throws Exception {
        String url = "http://erpnext.localhost:8000/api/resource/Payment Entry?filters=[[\"name\",\"=\",\""+name+"\"]]&fields=[\"*\"]";
        
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "token "+ApiKeyService.getAPiKey());

        HttpEntity<Void> entity = new HttpEntity<>(headers);
        ResponseEntity<JsonNode> response = restTemplate.exchange(url, HttpMethod.GET, entity, JsonNode.class);

        JsonNode dataNode = response.getBody().get("data");
        Payment[] po = objectMapper.treeToValue(dataNode, Payment[].class);
        if (po.length <= 0) return null;

        return Arrays.asList(po).get(0);
    }

    public Payment save(String reference_name, Payment payment) throws Exception {
        payment.setDocstatus(1);
        payment.setStatus("Submitted");
        Map<String, Object> references = new HashMap<>();
        references.put("reference_doctype", "Purchase Invoice");
        references.put("reference_name",reference_name);
        references.put("allocated_amount", payment.getPaid_amount());
        payment.setReferences(Arrays.asList(references));

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(payment);

        System.out.println("\nPAEIMENT : "+json+"\n\n");
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "token "+ApiKeyService.getAPiKey());

        HttpEntity<String> entity = new HttpEntity<>(json, headers);

        String url = "http://erpnext.localhost:8000/api/resource/Payment Entry";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);

        System.out.println(response.getBody());
        return payment;
    }
    
    public void createReference(String invoiceID, Payment payment) throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "token "+ApiKeyService.getAPiKey());

        HttpEntity<String> entity = new HttpEntity<>(headers);

        String url = "http://erpnext.localhost:8000/api/method/erpnext.controllers.rest.create_reference?payment_entry_name="+payment.getName()+"&reference_doctype=Purchase Invoice&reference_name="+invoiceID+"&allocated_amount="+payment.getPaid_amount();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        System.out.println(response.getBody());
    }
    
    public List<PaymentEntryReference> findAllReference(String name) throws Exception {
        String url = "http://erpnext.localhost:8000/api/method/erpnext.controllers.rest.get_references_for_payment_entry?payment_entry_name="+name;
        
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "token "+ApiKeyService.getAPiKey());

        HttpEntity<Void> entity = new HttpEntity<>(headers);
        ResponseEntity<JsonNode> response = restTemplate.exchange(url, HttpMethod.GET, entity, JsonNode.class);
        
        JsonNode dataNode = response.getBody().get("data").get("items");
        System.out.println(dataNode);
    
        PaymentEntryReference[] items = objectMapper.treeToValue(dataNode, PaymentEntryReference[].class);
        return Arrays.asList(items);
    }
    
    public List<Payment> findAll() throws Exception {
        String url = "http://erpnext.localhost:8000/api/resource/Payment Entry?fields=[\"*\"]";
        
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "token "+ApiKeyService.getAPiKey());

        HttpEntity<Void> entity = new HttpEntity<>(headers);
        ResponseEntity<JsonNode> response = restTemplate.exchange(url, HttpMethod.GET, entity, JsonNode.class);

        JsonNode dataNode = response.getBody().get("data");
        Payment[] po = objectMapper.treeToValue(dataNode, Payment[].class);

        return Arrays.asList(po);
    }
}
