package com.example.banabada.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "orders") //DB에 저장될때 orders로 저장, order는 예약어라 s붙여야함
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order {

    // 기본키
    @Id @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    private LocalDateTime orderDate;                            // 주문 시간

    @Enumerated(EnumType.STRING)  // Value가 String로 들어감
    private OrderStatus status;                                 // 주문 상태 (order, cancel)

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")                             // 양방향 관계 : Member
    private Member member;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();     // 주문 상품

    @OneToOne(fetch = LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;                                  // 배송

    @OneToOne(fetch = LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id")
    private Payment payment;                                    // 결제


}