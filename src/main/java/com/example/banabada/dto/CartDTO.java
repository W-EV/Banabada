package com.example.banabada.dto;

import com.example.banabada.model.CartItemEntity;
import com.example.banabada.model.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CartDTO {
    private String id;
    private UserEntity user;
    private List<CartItemEntity> cartItemList = new ArrayList<CartItemEntity>();
    private boolean yes;
}
