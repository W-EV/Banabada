package com.example.banabada.dto;

import com.example.banabada.model.OrderItemEntity;
import com.example.banabada.model.UserEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDTO {
    private String id;
    private UserEntity user;
    private List<OrderItemEntity> orderItemList = new ArrayList<OrderItemEntity>();
    private Date orderDate;
    private int total;
    private boolean payCheck;
    private int orderCnt;
}
