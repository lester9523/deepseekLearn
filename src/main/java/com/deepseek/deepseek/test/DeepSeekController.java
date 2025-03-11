package com.deepseek.deepseek.test;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lihao
 * @date 2025/3/11 16:21
 */
@RestController
@RequestMapping("/api/deepseek")
public class DeepSeekController {
    @Resource
    private DeepSeekService deepSeekService;

    @ResponseBody
    @RequestMapping("/chat")
    public String chat() {
        return deepSeekService.generateResponse("我现在想围绕着教育相关的app，涉及一个跟deepseek深度融合的产品，请给我一些建议和可行性方案。");
    }
}