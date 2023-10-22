package com.inditex.testapp.app.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inditex.testapp.app.services.IProductService;
import com.inditex.testapp.domain.model.Product;
import com.inditex.testapp.infrastructure.persistance.ProductRepository;

import reactor.core.publisher.Mono;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Mono<Product> getProductById(Long productId) {
        return productRepository.findByProductId(productId);
    }

}
