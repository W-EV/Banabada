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
@Entity(name="User")
@Table(name="User")
public class UserEntity {
        // 기본키
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String userId;

    // 사용자 이름
    @Column(nullable = false, unique = true)
    private String username;
    // 사용자 PW
    @Column(nullable = false)
    // @jsonIgnore : json에서 숨김처리
    private String password;
    // 사용자 이메일
    @Column(nullable = false)
    private String email;
    // 사용자 주소
    private String address;
    // 사용자 전화번호
    private String phoneNumber;
    // 구독 여부(OrderEntity/payCheck=True인 OrderEntity가 있으면 True)
    @Column(columnDefinition = "boolean default false")
    private Boolean subscription;

    /*
    // 마이페이지에서 사용자의 리뷰들 보일 때 사용
    @OneToMany(mappedBy = "user")
    private List<ReviewEntity> reviewList = new ArrayList<ReviewEntity>();
    // 마이페이지에서 사용자의 구독 상품 보일 때 사용
    @OneToMany(mappedBy = "order")
    private List<OrderEntity> orderList = new ArrayList<OrderEntity>();
    */

}



