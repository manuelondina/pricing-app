package com.inditex.testapp.app.services.impl;

import org.springframework.stereotype.Service;

import com.inditex.testapp.app.services.IProductService;
import com.inditex.testapp.domain.model.Product;
import com.inditex.testapp.infrastructure.persistance.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService {

    private final ProductRepository productRepository;

    @Override
    public Product getProductById(Long productId) {
        return productRepository.findByProductId(productId);
    }

}
