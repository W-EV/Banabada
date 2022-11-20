package com.example.banabada.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter @Setter
public class Delivery {

    // 기본키
    @Id
    @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery", fetch = LAZY)
    private Order order;       // 단방향                             // 주문

    @Embedded
    private Address address;                                // 주문자 주소

    @Enumerated(EnumType.STRING)  // Value가 String로 들어감
    private DeliveryStatus status;                          // 배달 상태

}
