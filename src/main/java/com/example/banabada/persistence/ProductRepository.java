package com.example.banabada.persistence;

import com.example.banabada.model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    Optional<ProductEntity> findById(Long id);
    List<ProductEntity> findByProductName(String name);
    List<ProductEntity> findAll();


}