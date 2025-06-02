package com.eval2.newapp.services;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import com.eval2.newapp.models.ApiResponse;

@Service
public class DatabaseService {
    @Autowired
    private RestTemplate restTemplate;

    public ApiResponse importCSV(MultipartFile file1, MultipartFile file2, MultipartFile file3) throws Exception {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        headers.set("Authorization", "token "+ApiKeyService.getAPiKey());

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("file1", convertToResource(file1));
        body.add("file2", convertToResource(file2));
        body.add("file3", convertToResource(file3));

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

        String url = "http://erpnext.localhost:8000/api/method/erpnext.custom_module.database_management.import_csv";
        ResponseEntity<ApiResponse> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, ApiResponse.class);
        return response.getBody();
    }
    

    private org.springframework.core.io.Resource convertToResource(MultipartFile file) throws IOException {
        return new org.springframework.core.io.ByteArrayResource(file.getBytes()) {
            @Override
            public String getFilename() {
                return file.getOriginalFilename();
            }
        };
    }

    
    public ApiResponse resetDatabase() throws Exception {
        String url = "http://erpnext.localhost:8000/api/method/erpnext.custom_module.database_management.reset_database_rest";
        
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "token "+ApiKeyService.getAPiKey());

        HttpEntity<Void> entity = new HttpEntity<>(headers);
        ResponseEntity<ApiResponse> response = restTemplate.exchange(url, HttpMethod.GET, entity, ApiResponse.class);
        return response.getBody();
    }
}
