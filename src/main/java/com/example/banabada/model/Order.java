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

    /*Order 회의 11.23
    연결 관련 - 어떻게?
    Order에 Delivery와 Payment가 연결된 것에 대해 어떻게 처리
    == >
     */

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



    //==연관관계 메서드==//
    public void setMember(Member member) {
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

    public void setPayment(Payment payment){
        this.payment = payment;
        payment.setOrder(this);
    }


    //주문생성 메서드
    public static Order createOrder(Member member, Delivery delivery, Payment payment, OrderItem... orderItems) {
        Order order = new Order();
        order.setMember(member);
        order.setDelivery(delivery);
        order.setPayment(payment);
        for (OrderItem orderItem : orderItems) {
            order.addOrderItem(orderItem);
        }
        order.setStatus(OrderStatus.ORDER);
        order.setOrderDate(LocalDateTime.now());
        return order;
    }


    //==비즈니스 로직==//
    // 주문 취소
    public void cancel() {
        if(delivery.getStatus() == DeliveryStatus.COMP && payment.getStatus() == PaymentStatus.COMP) {
            throw new IllegalStateException("이미 배송 및 결제 완료된 상품은 취소가 불가능합니다.");
        }
        this.setStatus(OrderStatus.CANCEL);
        for (OrderItem orderItem: orderItems) {
            orderItem.cancel();
        }
    }

    //==조회 로직==//
    // 전체 주문 가격 조회 :: 추후 버전 업데이트하며 개별상품 판매 게시 용도
    public int getOrderPrice(){
        return orderItems.stream()
                .mapToInt(OrderItem::getOrderPrice)
                .sum();
    }
}