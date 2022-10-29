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
    private String paymentId;

        // 외래 키
    // 주문 ID(결제 완료 후 OrderEntity/payChekc=True)
    @OneToOne
    @JoinColumn(name="orderId")
    private OrderEntity order;
    // 사용자 ID(결제 정보)
    @OneToOne
    @JoinColumn(name="userId")
    private UserEntity user;

    // 결제 수단
    private String payMethod;
    // 결제 금액
    private int totalPrice;
}
