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
@Table(name="Carts")
public class CartEntity {
    // 기본 키
    // 장바구니 ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 외래 키
    // 사용자 ID
    @OneToOne
    @JoinColumn
    private UserEntity user;
    // 스프링 어노테이션 @AuthenticationPrincipal 사용하여 세션정보 넘길 수 있음
    // private String userId;로 변경 고민 중  --> OneToOne도 가능한지 봐야 함
    // 장바구니 상품 ID
    @OneToMany(mappedBy="cart")
    private List<CartItemEntity> cartItemList = new ArrayList<CartItemEntity>();

    private boolean yes; // true : 기본적으로 선택하는 걸로 결정!



}
