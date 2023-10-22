package com.inditex.testapp.app.services;

import java.util.Date;

import com.inditex.testapp.domain.model.Price;
import com.inditex.testapp.domain.model.Product;

import reactor.core.publisher.Mono;

public interface IPriceService {

    Mono<Price> getProductPrice(Product productId, Long brandId, Date date);

}
