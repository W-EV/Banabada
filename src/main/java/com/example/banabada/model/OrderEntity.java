package com.example.banabada.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// OrderEntity : 최종 구매 완료한 상품 집합 테이블
// OrderHistoryEntity 없이, 현재 구독 중인 상품에 대해서만

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="Orders")
public class OrderEntity {
    // 기본키
    // 주문 ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    // 외래 키
    // 사용자 ID
    @OneToOne
    @JoinColumn
    private UserEntity user;
    // 스프링 어노테이션 @AuthenticationPrincipal 사용하여 세션정보 넘길 수 있음
    // private String userId;로 변경 고민 중  --> OneToOne도 가능한지 봐야 함
    // 주문 상품 ID
    @OneToMany(mappedBy="order")
    private List<OrderItemEntity> orderItemList = new ArrayList<OrderItemEntity>();

    // 주문날짜
    //@Column(columnDefinition = "datetime default NOW()")
    private Date orderDate;
    // 총 주문량
    private int total;
    // 결제여부(결제 후 결정)
    //@Column(columnDefinition = "boolean default false")
    private boolean payCheck;
    // 주문 횟수?? OrderHistory??
    private int orderCnt;

}

/*
//OrderEntity 수정 > DeliveryEntity 추가, Item과 User(Member를 User로 수정하기) 수정..

package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter @Setter
public class Order {

    @Id @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    //주문상품
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();

    //배송
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    private LocalDateTime orderDate; //주문시간

    @Enumerated(EnumType.STRING) //꼭 스트링 써주기!(상태값 추가할수 있음)
    private OrderStatus status; //주문상태 [ORDER, CANCEL] ::바나바다에서는 배송현황, 구독현황으로 응용

    //==연관관계 메서드==//
    public void serMember(Member member){
        this.member = member;
        member.getOrders().add(this);
    }

    public void addOrderItem(OrderItem orderItem){
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

    public void setDelivery(Delivery delivery){
        this.delivery = delivery;
        delivery.setOrder(this);
    }

}

 */