package com.example.banabada.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CartItem {

    // 기본키
    @Id @GeneratedValue
    @Column(name = "cart_item_id")
    private Long id;

    private int count;              // 상품 개수

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "item_id")
    private Item item;              // 상품

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "cart_id")
    private Cart cart;            // 장바구니




//  protected CartItem() { }

}
