package com.example.banabada.model;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Address {

    private String city;    // 도시
    private String street;  // 거리
    private String zipcode; // 우편번호

}
