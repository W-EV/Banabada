package com.example.banabada.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

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
@Entity(name="Order")
@Table(name="Order")
public class OrderEntity {
        // 기본키
    // 주문 ID
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid",strategy = "uuid")
    private String orderId;

        // 외래 키
    // 사용자 ID
    @OneToOne
    @JoinColumn(name="userId")
    private UserEntity user;
    // 주문 상품 ID
    @OneToMany(mappedBy="order")
    private List<OrderItemEntity> orderItemList = new ArrayList<OrderItemEntity>();

    // 주문날짜
    @Column(columnDefinition = "datetime default NOW()")
    private Date orderDate;
    // 총 주문량
    private int total;
    // 결제여부(결제 후 결정)
    @Column(columnDefinition = "boolean default false")
    private boolean payCheck;
    // 주문 횟수?? OrderHistory??
    private int orderCnt;

}
