package com.example.banabada.controller;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;


// import javax.validation.constraints.NotEmpty; --> column(nullable = false)로 수정

@Getter @Setter
public class MemberForm {

    private String name;                                            // 사용자 이름
    private String password;                                        // 사용자 PW
    private String email;                                           // 사용자 이메일
    private String phoneNumber;                                     // 사용자 전화번호
//  @Embedded
    private String address;                                         // 사용자 주소
}
