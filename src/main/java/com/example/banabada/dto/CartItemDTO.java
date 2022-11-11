package com.example.banabada.dto;

import com.example.banabada.model.CartEntity;
import com.example.banabada.model.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CartItemDTO {
    private String id;
    private CartEntity cart;
    private ProductEntity product;
}
