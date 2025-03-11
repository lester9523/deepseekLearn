package com.deepseek.deepseek.test;

import lombok.Data;

import java.util.List;

/**
 * @author lihao
 * @date 2025/3/11 16:10
 */
@Data
public class DeepSeekResponse {
    private List<Choice> choices;

    @Data
    public static class Choice {
        private Message message;

        @Data
        public static class Message {
            private String content;
        }
    }
}