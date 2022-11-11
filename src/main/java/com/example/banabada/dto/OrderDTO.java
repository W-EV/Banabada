package com.example.banabada.dto;

import com.example.banabada.model.OrderItemEntity;
import com.example.banabada.model.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDTO {
    private String id;
    private UserEntity user;
    private List<OrderItemEntity> orderItemList = new ArrayList<OrderItemEntity>();
    private Date orderDate;
    private int total;
    private boolean payCheck;
    private int orderCnt;
}
