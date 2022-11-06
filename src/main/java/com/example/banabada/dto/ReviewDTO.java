package com.example.banabada.dto;

import com.example.banabada.model.OrderEntity;
import com.example.banabada.model.UserEntity;

public class ReviewDTO {
    private String id;
    private UserEntity user;
    // private String userId;
    private OrderEntity order;
    private String reviewContent;
    private String reviewTitle;
    private String extName;
}
