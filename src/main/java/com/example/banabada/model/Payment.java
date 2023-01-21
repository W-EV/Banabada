package com.example.banabada.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter @Setter
public class Payment {

    // 기본키
    @Id @GeneratedValue
    @Column(name = "payment_id")
    private Long id;


    private String payMethod;// 결제 수단
    //List<String> list = new ArrayList<>();

    private int totalPrice;    // 결제 금액

    @OneToOne(mappedBy = "payment", fetch = LAZY)
    private Order order;       // 단방향                             // 주문
                            // 주문자 주소

    @Enumerated(EnumType.STRING)  // Value가 String로 들어감
    private PaymentStatus status;                          // 배달 상태

    //== 생성자 ==//

}



