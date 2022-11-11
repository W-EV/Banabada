package com.example.banabada.dto;

import com.example.banabada.model.OrderEntity;
import com.example.banabada.model.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PaymentDTO {
    private String id;
    private OrderEntity order;
    private UserEntity user;
    // private String userId;
    private String payMethod;
    private int totalPrice;
}
