package com.example.banabada.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter @Setter
public class Member {

    // 기본키
    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;                                            // 사용자 이름
    private String password;                                        // 사용자 PW
    private String email;                                           // 사용자 이메일
    private String phoneNumber;                                     // 사용자 전화번호
    private boolean subscription;                                   // 구독 여부(주문 상품이 하나라도 있는 경우 true)

    @Embedded
    private Address address;                                        // 사용자 주소

    @OneToMany(mappedBy = "member")                     // 양방향 관계
    private List<Order> orders = new ArrayList<>();                 // 주문

    @OneToOne(fetch = LAZY, cascade = CascadeType.ALL)  // 단방향
    @JoinColumn(name = "cart_id")
    private Cart cart;                                              // 장바구니




}
