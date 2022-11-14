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
@Entity
@Table(name="CartItems")
public class CartItemEntity {
    // 기본 키
    // 장바구니 상품 ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 외래 키
    // 장바구니 ID
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private CartEntity cart;
    // 상품 ID
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private ProductEntity product;

    // 상품 개수
    private int count;

    public static CartItemEntity createCartItem(CartEntity cart, ProductEntity product, int amount) {
        CartItemEntity cartItem = new CartItemEntity();
        cartItem.setCart(cart);
        cartItem.setProduct(product);
        cartItem.setCount(amount);
        return cartItem;
    }

    // 이미 담겨있는 물건 또 담을 경우 수량을 증가시키기
    public void addCount(int count) {
        this.count += count;
    }

}
