package com.example.banabada.dto;

import com.example.banabada.model.CartItemEntity;
import com.example.banabada.model.OrderItemEntity;
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
public class ProductDTO {
    private String id;
    private String productName;
    private int productPrice;
    private String productInfo;
    private String productImgPath;
    private Date enrollDate;
    private List<CartItemEntity> cartItemList = new ArrayList<CartItemEntity>();
    private List<OrderItemEntity> orderItemList = new ArrayList<OrderItemEntity>();
}
