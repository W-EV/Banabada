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
public class OrderItemDTO {
    private String id;
    private CartEntity order;
    private ProductEntity product;


}
