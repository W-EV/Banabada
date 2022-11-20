package com.example.banabada.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "carts")
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Cart {

    // 기본키
    @Id @GeneratedValue
    @Column(name = "cart_id")
    private Long id;                                            // 장바구니에서 체크표시한 상품 개수? 장바구니 속 상품 총 개수?

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private List<CartItem> cartItems = new ArrayList<>();       // 주문 상품

    @OneToOne(mappedBy = "cart", fetch = LAZY)  // 단방향
    private Member member;                                      // 사용자

    /* 장바구니와 주문을 잇는 방법 아직 모르겠어서 주석 처리함 : 장바구니 상품과 주문 상품이 item으로 연결되어있으니까 안 해줘도 되는지..?
    @OneToOne(mappedBy = "cart", fetch = LAZY)
    private Order order;                                        // 주문
    
     */

}