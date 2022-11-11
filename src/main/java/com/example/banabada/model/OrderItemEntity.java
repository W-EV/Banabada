package com.example.banabada.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="OrderItems")
public class OrderItemEntity {
    // 기본 키
    // 주문 상품 ID
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid",strategy = "uuid")
    private String id;

    // 외래 키
    // 주문 ID
    @ManyToOne
    @JoinColumn
    private CartEntity order;
    // 상품 ID
    @ManyToOne
    @JoinColumn
    private ProductEntity product;
}
