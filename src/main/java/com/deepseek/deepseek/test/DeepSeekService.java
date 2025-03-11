package com.deepseek.deepseek.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author lihao
 * @date 2025/3/11 16:17
 */
@Service
public class DeepSeekService {
    @Value("${deepseek.api.key}")
    private String apiKey;

    @Value("${deepseek.api.url}")
    private String apiUrl;

    private final RestTemplate restTemplate = new RestTemplate();


    public String generateResponse(String userInput) {
        // 构建请求头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(apiKey);

        // 构造请求体（网页3）
        DeepSeekRequest request = new DeepSeekRequest();

        DeepSeekRequest.Message message = new DeepSeekRequest.Message();
        message.setRole("user");
        message.setContent(userInput);
        request.setMessages(List.of(
                message
        ));

        // 发送API请求（网页3）
        HttpEntity<DeepSeekRequest> entity = new HttpEntity<>(request, headers);
        ResponseEntity<DeepSeekResponse> response = restTemplate.exchange(
                apiUrl, HttpMethod.POST, entity, DeepSeekResponse.class);

        // 解析响应（网页3）
        return response.getBody().getChoices().get(0)
                .getMessage().getContent();
    }
}
