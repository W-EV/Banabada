package com.example.banabada.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseDTO<T> {
    private String error;
    private List<T> data;  // 상품 여러 개 반환하는 경우가 많을 것이므로 리스트에 담아 반환하려고 함
}
