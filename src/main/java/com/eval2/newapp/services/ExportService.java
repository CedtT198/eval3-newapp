package com.eval2.newapp.services;

import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class ExportService {
    
    @Autowired
    private RestTemplate restTemplate;
    
    public void printToPdfSalarySlip(String ref, HttpServletResponse response) throws Exception {
        // ref = URLEncoder.encode(ref, StandardCharsets.UTF_8);
        String url = "http://erpnext.localhost:8000//api/method/frappe.utils.print_format.download_pdf?doctype=Salary Slip&name="+ref+"&format=Standard&no_letterhead=0&letterhead=&settings={}&_lang=en";
        
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "token "+ApiKeyService.getAPiKey());
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_PDF));

        HttpEntity<Void> entity = new HttpEntity<>(headers);
        restTemplate.getMessageConverters().add(new ByteArrayHttpMessageConverter());

        ResponseEntity<byte[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, byte[].class);

        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=\""+ref+".pdf\"");
            response.setContentLength(responseEntity.getBody().length);
            response.getOutputStream().write(responseEntity.getBody());
            response.getOutputStream().flush();
            // byte[] pdfBytes = response.getBody();
            // try (FileOutputStream fos = new FileOutputStream(ref+".pdf")) {
            //     fos.write(pdfBytes);
            // }
        } else {
            throw new RuntimeException("Downloading PDF failed : " + responseEntity.getStatusCode());
        }
    }
}
