package com.example.banabada.service;

import com.example.banabada.model.ProductEntity;
import com.example.banabada.model.UserEntity;
import com.example.banabada.persistence.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity create(final UserEntity userEntity) {
        validate(userEntity);

        return userRepository.save(userEntity);
    }

    public UserEntity getByCredentials(final String email, final String password) {
        return userRepository.findByEmailAndPassword(email, password);  //
    }


    private void validate(final UserEntity entity) {
        if (entity == null || entity.getEmail() == null) {
            throw new RuntimeException("Invalid arguments");
        }
        final String email = entity.getEmail();
        if(userRepository.existsByEmail(email)) {
            log.warn("Email already exists {}", email);
            throw new RuntimeException("Email already exists");
        }
    }
}
