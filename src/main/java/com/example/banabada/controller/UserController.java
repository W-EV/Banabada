package com.example.banabada.controller;

import com.example.banabada.dto.ResponseDTO;
import com.example.banabada.dto.UserDTO;
import com.example.banabada.model.UserEntity;
import com.example.banabada.security.TokenProvider;
import com.example.banabada.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.UserDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("banabada/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenProvider tokenProvider;

    // 회원가입 페이지
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody UserDTO userDTO) {
        try {
            // 요청을 이용해 저장할 사용자 만들기 (웹에서 전달된 DTO 정보를 Entity로 변환)
            UserEntity user = UserEntity.builder()
                    .email(userDTO.getEmail())
                    .username(userDTO.getUsername())
                    .password(userDTO.getPassword())
                    .build();
            // service 이용해 repository에 사용자 저장 (변환한 Entity를 DB에 저장)
            UserEntity registeredUser = userService.create(user);
            UserDTO responseUserDTO = UserDTO.builder() // (DB에 저장한 Entity를 다시 DTO로 변환)
                    .email(registeredUser.getEmail())
                    .id(registeredUser.getId())
                    .username(registeredUser.getUsername())
                    .build();

            return ResponseEntity.ok().body(responseUserDTO);  // DTO를 응답 반환
        } catch (Exception e) {
            // 사용자 정보는 항상 하나이므로 리스트로 만들어야 하는 ResponseDTO를 사용하지 않고 그냥 UserDTO 반환
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return ResponseEntity
                    .badRequest()
                    .body(responseDTO);
        }
    }



    // 로그인 페이지
    @PostMapping("/signin")
    public ResponseEntity<?> authenticate(@RequestBody UserDTO userDTO) {
        // DB에서 email, password를 가진 UserEntity 찾기
        UserEntity user = userService.getByCredentials(
                userDTO.getEmail(),
                userDTO.getPassword());

        // DB에 있는 사용자라면 UserEntity를 DTO로 변환하여 반환
        if (user != null) {
            // 토큰 생성
            final String token = tokenProvider.create(user);
            final UserDTO responseUserDTO = UserDTO.builder()
                    .email(user.getEmail())
                    .id(user.getId())
                    .token(token)
                    .build();
            return ResponseEntity.ok().body(responseUserDTO);
        } else {
            ResponseDTO responseDTO = ResponseDTO.builder()
                    .error("Login failed")
                    .build();
            return ResponseEntity
                    .badRequest()
                    .body(responseDTO);
        }

    }



}
