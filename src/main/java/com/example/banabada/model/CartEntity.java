package com.example.banabada.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name="Cart")
@Table(name="Cart")

//CartEntity 구현 1114수정
public class CartEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private UserEntity user; // 구매자

    private int count; // 카트에 담긴 총 상품 개수

    @OneToMany(mappedBy = "cart")
    private List<CartItemEntity> cartItems = new ArrayList<>();

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate createDate; // 날짜

    @PrePersist
    public void createDate(){
        this.createDate = LocalDate.now();
    }

    public static CartEntity createCart(UserEntity user) {
        CartEntity cart = new CartEntity();
        cart.setCount(0);
        cart.setUser(user);
        return cart;
    }

}
