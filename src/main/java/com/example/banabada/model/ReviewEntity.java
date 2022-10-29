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
@Entity(name="Review")
@Table(name="Review")
public class ReviewEntity {
        // 기본키
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid",strategy = "uuid")
    private String reviewId;    // 리뷰 ID

        // 외래키
    // 사용자 ID
    @ManyToOne
    @JoinColumn(name="userId")
    private UserEntity user;
    // 주문 상품 ID
    @ManyToOne
    @JoinColumn(name="orderId")
    private OrderEntity order;

    // 리뷰 내용
    private String reviewContent;
    // 리뷰 제목
    private String reviewTitle;
    // 확장자명
    private String extName;
    // ImageField (구현 x) : private Image(?) reviewImg;


}
