package com.example.banabada.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name="Payment")
@Table(name="Payment")
public class PaymentEntity {
    // 기본 키
    // 결제 ID
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid",strategy = "uuid")
    private String id;

    // 외래 키
    // 주문 ID(결제 완료 후 OrderEntity/payChekc=True)
    @OneToOne
    @JoinColumn(name="id")
    private OrderEntity order;
    // 사용자 ID(결제 정보)
    @OneToOne
    @JoinColumn(name="id")
    private UserEntity user;
    // 스프링 어노테이션 @AuthenticationPrincipal 사용하여 세션정보 넘길 수 있음
    // private String userId;로 변경 고민 중

    // 결제 수단
    private String payMethod;
    // 결제 금액
    private int totalPrice;
}

