package com.example.banabada.service;

import com.example.banabada.model.ProductEntity;
import com.example.banabada.persistence.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/*
구독 상품 생성, 수정, 조회, 삭제
(= 상품 게시글 생성, 수정, 조회, 삭제)
*/

@Service
@Slf4j
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Optional<ProductEntity> create(final ProductEntity entity) {

        validate(entity);

        repository.save(entity);
        log.info("ProductEntity Id : {} is saved.", entity.getId());

        Optional<ProductEntity> productEntity = repository.findById(entity.getId());
        if (!productEntity.isPresent()) {
            throw new IllegalArgumentException();
        } else {
            return productEntity;
        }
    }

    public List<ProductEntity> retrieve(final String productName) {
        return repository.findByProductName(productName);
    }

    /*
    public String testService() {
        // ProductEntity 생성
        ProductEntity entity = ProductEntity.builder()
                .productName("상품1")
                .productPrice(1000)
                .build();
        // ProductEntity 저장
        repository.save(entity);
        // ProductEntity 검색
        Optional<ProductEntity> productEntity = repository.findById(entity.getId());
        if (!productEntity.isPresent()) {
            throw new IllegalArgumentException();

        } else {
            ProductEntity savedEntity = productEntity.get();
            return savedEntity.getProductName();
        }
    }
    */


    private void validate(final ProductEntity entity) {
        if (entity == null) {
            log.warn("ProductEntity cannot be null.");
            throw new RuntimeException("ProductEntity cannot be null.");
        }

        if (entity.getId()==null) {
            log.warn("Unknown product.");
            throw new RuntimeException("Unknown product.");
        }
    }


}