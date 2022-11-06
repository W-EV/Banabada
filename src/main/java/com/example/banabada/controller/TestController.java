package com.example.banabada.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

    // 서버 작동 여부 test 페이지
    @GetMapping
    public String testController() {
        return "Hello World!";
    }
}
