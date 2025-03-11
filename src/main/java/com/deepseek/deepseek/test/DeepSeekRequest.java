package com.deepseek.deepseek.test;

import lombok.Data;

import java.util.List;

/**
 * @author lihao
 * @date 2025/3/11 16:08
 */
// 1. 请求响应模型（网页3）
@Data
public class DeepSeekRequest {
    private String model = "deepseek-chat";
    private List<Message> messages;

    @Data
    public static class Message {
        private String role;
        private String content;
    }

}