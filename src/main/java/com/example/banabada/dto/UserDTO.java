package com.example.banabada.dto;

import com.example.banabada.model.ProductEntity;
import com.example.banabada.model.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {

    private String token;
    private String email;
    private String username;
    private String password;
    private Long id;
    private String address;
    private String phoneNumber;
    private boolean subscription;

    public UserDTO(final UserEntity entity) {
        this.id = entity.getId();
        this.username = entity.getUsername();
        this.password = entity.getPassword();
        this.email = entity.getEmail();
        this.address = entity.getAddress();
        this.phoneNumber = entity.getPhoneNumber();
        this.subscription = entity.isSubscription();
    }

    public static UserEntity toEntity(final UserDTO dto) {
        return UserEntity.builder()
                .id(dto.getId())
                .username(dto.getUsername())
                .password(dto.getPassword())
                .email(dto.getEmail())
                .address(dto.getAddress())
                .phoneNumber(dto.getPhoneNumber())
                .subscription(dto.isSubscription())
                .build();
    }


}
