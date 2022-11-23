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
public class OrderItem {

    // 기본키
    @Id @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;


    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "item_id")
    private Item item;              // 상품

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "order_id")
    private Order order;            // 주문
    private int orderPrice;         // 주문 가격
    private int count=1;              // 주문 상품 수량 :: 현재 구독은 1개만 할 수 있지만, 추후 개별 상품 분화/파생상품 등 판매 예정을 위한 업데이트를 위해 남겨둠

    //==생성 메서드==//
    public static OrderItem createOrderItem(Item item, int orderPrice) {
        OrderItem orderItem = new OrderItem();
        orderItem.setItem(item);
        orderItem.setOrderPrice(orderPrice);

        item.removeStock(1);
        return orderItem;
    }

    //==비즈니스 로직==//
    public void cancel() {
        getItem().addStock(count);
    }

//  protected OrderItem() { }

   }
