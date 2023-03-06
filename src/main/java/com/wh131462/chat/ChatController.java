package com.wh131462.chat;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ChatController {
    @PostMapping("/chat")
    public ResponseEntity<String> chat(@RequestBody String message){
        RestTemplate restTemplate = new RestTemplate();

        String url = "https://api.openai.com/v1/engines/davinci-codex/completions";
        String prompt = message;
        String apiKey = "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";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + apiKey);

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("prompt", prompt);
        requestBody.put("max_tokens", 50);

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(requestBody, headers);

        Map<String, Object> response = restTemplate.postForObject(url, request, Map.class);
        System.out.println(response);
//        String chatResponse = (String) response.get("choices").get(0).get("text");
        return  ResponseEntity.ok("三十岁");
    }
}
