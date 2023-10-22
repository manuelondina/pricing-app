package com.inditex.testapp.infrastructure.persistance;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import com.inditex.testapp.domain.model.Product;

import reactor.core.publisher.Mono;

@Repository
public interface ProductRepository extends R2dbcRepository<Product, Long> {

    Mono<Product> findByProductId(Long productId);

}