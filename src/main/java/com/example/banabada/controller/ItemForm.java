package com.example.banabada.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemForm {
    private String name;            // 상품명
    private int price;              // 가격
    private int stockQuantity;      // 재고 수량
    private String productImgPath;  // 상품 이미지 (참고 study.txt [1] 이미지 조회 경로)
    private String productInfo;
}


