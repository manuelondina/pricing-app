package com.inditex.testapp.app.services;

import com.inditex.testapp.domain.model.Product;

import reactor.core.publisher.Mono;

public interface IProductService {

    Mono<Product> getProductById(Long id);

}
