package com.example.banabada.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter @Setter
public class Category {  // 카테고리 추가 기능 --> 구현 안 함

    // 기본키
    @Id @GeneratedValue
    @Column(name = "category_id")
    private Long id;

    private String name;                                            // 카테고리명

    @ManyToMany
    @JoinTable(name = "category_item",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))
    private List<Item> items = new ArrayList<>();                   // 아이템

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "parent_id")
    private Category parent;                                        // 부모

    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>();               // 자식


    //==연관관계 메서드==//
    public void addChildCategory(Category child) {
        this.child.add(child);
        child.setParent(this);
    }
}
