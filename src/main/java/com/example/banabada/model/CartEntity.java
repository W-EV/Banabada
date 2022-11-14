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

    //기본키
    //장바구니 ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name="system-uuid",strategy = "uuid")
    private String id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="username") //entity 내부에서 joincolum 이름이 같으면 안됨
    private UserEntity user; // 구매자

    private int count; // 카트에 담긴 총 상품 개수

    @OneToMany(mappedBy = "cart")
    private List<CartItemEntity> cartItems = new ArrayList<>();

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate createDate; // 날짜(장바구니 담은 날짜, 필요한 이유는 ㅁㄹ)

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
