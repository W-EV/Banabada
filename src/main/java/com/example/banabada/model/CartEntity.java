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
@Entity(name="Cart")
@Table(name="Cart")
public class CartEntity {
        // 기본 키
    // 장바구니 ID
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid",strategy = "uuid")
    private String cartId;

        // 외래 키
    // 사용자 ID
    @OneToOne
    @JoinColumn(name="userId")
    private UserEntity user;
    // 장바구니 상품 ID
    @OneToMany(mappedBy="cart")
    private List<CartItemEntity> cartItemList = new ArrayList<CartItemEntity>();



}
