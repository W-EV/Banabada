package com.example.banabada.controller;

import com.example.banabada.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// localhost:8080
@RestController
@RequestMapping("banabada")
public class BanabadaController {

    @Autowired
    private ProductService service;


    /*/ home 페이지
    @GetMapping("/")

    // 전체 상품 조회 페이지
    // 여유시, 페이지네이션 기능 추가
    @GetMapping("/products")

    // 상품 상세 페이지
    @GetMapping("/products/id={id}")



    //*/

}
