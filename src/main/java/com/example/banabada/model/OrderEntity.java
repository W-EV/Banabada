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
@Entity
@Table(name="Orders")
public class OrderEntity {
    // 기본키
    // 주문 ID
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid",strategy = "uuid")
    private String id;

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
