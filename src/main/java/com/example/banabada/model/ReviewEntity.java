package com.example.banabada.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="Reviews")
public class ReviewEntity {
    // 기본키
    // 리뷰 ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 외래키
    // 사용자 ID
    @ManyToOne
    @JoinColumn
    private UserEntity user;
    // 스프링 어노테이션 @AuthenticationPrincipal 사용하여 세션정보 넘길 수 있음
    // private String userId;로 변경 고민 중

    // 주문 상품 ID
    @ManyToOne
    @JoinColumn
    private OrderEntity order;

    // 리뷰 내용
    private String reviewContent;
    // 리뷰 제목
    private String reviewTitle;
    // 확장자명
    private String extName;


}

