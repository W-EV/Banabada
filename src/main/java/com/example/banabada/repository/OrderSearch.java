package com.example.banabada.repository;

import com.example.banabada.model.OrderStatus;
import lombok.Getter;
import lombok.Setter;

//내부 동작을 위해 만든 클래스
@Getter @Setter
public class OrderSearch {
    private String memberName; //회원 이름
    private OrderStatus orderStatus; //주문 상태
}
