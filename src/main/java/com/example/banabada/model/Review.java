package com.example.banabada.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Review {
    // 연관 관계 설정 아직 못함

    // 기본키
    @Id @GeneratedValue
    private Long id;


    private String reviewContent;   // 리뷰 내용
    private String reviewTitle;     // 리뷰 제목
    private String extName;         // 확장자명


    /*
    // 주문 상품 ID
    @ManyToOne
    @JoinColumn
    private Order order;

    // 멤버 ID
    @ManyToOne
    @JoinColumn
    private Member member;
    */

}
