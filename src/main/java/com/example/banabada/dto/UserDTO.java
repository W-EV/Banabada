package com.example.banabada.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {

    private String id;
    private String password;
    private String username;
    private String email;
    private String address;
    private String phoneNumber;
    private String subscription;

    // private String token;
    // private String errorMsg;


}
