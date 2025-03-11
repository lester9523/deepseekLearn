package com.deepseek.deepseek.test;

/**
 * @author lihao
 * @date 2025/3/11 16:06
 */
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class DeepSeekClient {
    private static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
    private final OkHttpClient client = new OkHttpClient();

    public String sendRequest(String prompt) throws Exception {
        // 1. 构建请求体
        String json = String.format("{\"model\":\"deepseek-chat\",\"messages\":[{\"role\":\"user\",\"content\":\"%s\"}]}", prompt);

        // 2. 创建Request对象
        Request request = new Request.Builder()
                .url("https://api.deepseek.com/v1/chat/completions")
                .addHeader("Authorization", "Bearer YOUR_API_KEY")
                .post(RequestBody.create(json, JSON))
                .build();

        // 3. 执行请求
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
}
