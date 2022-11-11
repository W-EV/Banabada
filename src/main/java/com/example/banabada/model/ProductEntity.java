package com.example.banabada.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name="Product")
@Table(name="Product")
public class ProductEntity {
    // 기본키
    // 상품 ID
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid",strategy = "uuid")
    private String id;

    // 상품명
    @Column(nullable = false)
    private String productName;
    // 상품 가격
    @Column(nullable = false)
    private int productPrice;
    // 상품 상세설명
    private String productInfo;
    // 상품 이미지
    private String productImgPath; // 참고 study.txt [1] 이미지 조회 경로
    // 상품 등록일
    //@Column(columnDefinition = "datetime default NOW()")
    private Date enrollDate;

    @OneToMany
    private List<CartItemEntity> cartItemList = new ArrayList<CartItemEntity>();
    @OneToMany
    private List<OrderItemEntity> orderItemList = new ArrayList<OrderItemEntity>();



    // (추가 기능)
    // private String categoryId;
}


