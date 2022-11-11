package com.example.banabada.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="Categories")
// 추가기능 Entity
public class CategoryEntity {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid",strategy = "uuid")
    private String id;  // 카테고리 ID (PK)

    private String productId;   // 상품 ID (FK)

    private String categoryName;    // 카테고리명

}
