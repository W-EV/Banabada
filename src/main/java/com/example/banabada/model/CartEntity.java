package com.example.banabada.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
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
@Entity
@Table(name="Carts")
public class CartEntity {
    // 기본 키 안녕하세요 다은입니다.
    // 장바구니 ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 외래 키
    // 사용자 ID
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn //entity 내부에서 joincolum 이름이 같으면 안됨
    private UserEntity user;  // 구매자
    // 스프링 어노테이션 @AuthenticationPrincipal 사용하여 세션정보 넘길 수 있음
    // private String userId;로 변경 고민 중  --> OneToOne도 가능한지 봐야 함
    // 카트에 담긴 총 상품 개수
    private int count;
    // 장바구니 상품 ID
    @OneToMany(mappedBy="cart")
    private List<CartItemEntity> cartItemList = new ArrayList<CartItemEntity>();

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate createDate; // 날짜(장바구니 담은 날짜, 필요한 이유는 ㅁㄹ)

    private boolean yes; // true : 기본적으로 선택하는 걸로 결정!



}
