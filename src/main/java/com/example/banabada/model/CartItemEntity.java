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

        @Id
        // 기본 키
        // 장바구니 상품 ID
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @GenericGenerator(name="system-uuid",strategy = "uuid")
        private String id;

        // 외래 키
        // 장바구니 ID
        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name="cartId")
        private CartEntity cart;

        // 상품 ID
        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name="productId")
        private ProductEntity product;

        private int count; // 상품 개수

        public static CartItemEntity createCartItem(CartEntity cart, ProductEntity product, int amount) {
            CartItemEntity cartItem = new CartItemEntity();
            cartItem.setCart(cart);
            cartItem.setProduct(product);
            cartItem.setCount(amount);
            return cartItem;
        }

        // 이미 담겨있는 물건 또 담을 경우 수량 증가
        public void addCount(int count) {
            this.count += count;
        }

    }

}
