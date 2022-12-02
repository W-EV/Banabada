package com.example.banabada.model;

import com.example.banabada.exception.NotEnoughStockException;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
/*//== 상속 관계 관련 Annotation
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")//*/
public class Item {

    // 기본키
    @Id @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;            // 상품명
    private int price;              // 가격
    private int stockQuantity;      // 재고 수량
    private String productImgPath;  // 상품 이미지 (참고 study.txt [1] 이미지 조회 경로) --> HTML 상에서 직접 업로드 하기로 결정
    private String productInfo;     // 상품 상세설명(채소 구성 설명)
//  private Date enrollDate; 제외


    // 카테고리 추가 기능 --> 구현 안 함
    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();


    //==비즈니스 로직==//

    // 재고 증가
    public void addStock(int quantity) { this.stockQuantity += quantity; }
    // 재고 감소
    public void removeStock(int quantity) {
        int restStock = this.stockQuantity - quantity;
        if(restStock < 0) {
            throw new NotEnoughStockException("need more stock");
        }
        this.stockQuantity -= quantity;
    }


    /* 기존 banabada(인강x)
    @OneToMany
    private List<CartItemEntity> cartItemList = new ArrayList<CartItemEntity>();
    @OneToMany
    private List<OrderItemEntity> orderItemList = new ArrayList<OrderItemEntity>();
    */
}


