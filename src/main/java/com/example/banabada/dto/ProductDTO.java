package com.example.banabada.dto;

import com.example.banabada.model.CartItemEntity;
import com.example.banabada.model.OrderItemEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductDTO {
    private String id;
    private String productInfo;
    private int productPrice;
    private String productName;
    private Date enrollDate;
    private List<CartItemEntity> cartItemList = new ArrayList<CartItemEntity>();
    private List<OrderItemEntity> orderItemList = new ArrayList<OrderItemEntity>();
}
