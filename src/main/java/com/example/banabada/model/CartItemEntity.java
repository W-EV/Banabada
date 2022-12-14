package com.example.banabada.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name="CartItem")
@Table(name="CartItem")
public class CartItemEntity {
        // 기본 키
    // 장바구니 상품 ID
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid",strategy = "uuid")
    private String cartItemId;

        // 외래 키
    // 장바구니 ID
    @ManyToOne
    @JoinColumn(name="cartId")
    private CartEntity cart;
    // 상품 ID
    @ManyToOne
    @JoinColumn(name="productId")
    private ProductEntity product;

}
