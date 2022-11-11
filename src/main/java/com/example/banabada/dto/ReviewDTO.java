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
public class ReviewDTO {
    private String id;
    private UserEntity user; // userId 추출
    private OrderEntity order;
    private String reviewContent;
    private String reviewTitle;
    private String extName;
}
