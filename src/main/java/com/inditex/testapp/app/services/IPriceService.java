package com.inditex.testapp.app.services;

import java.time.LocalDateTime;

import com.inditex.testapp.domain.model.Price;
import com.inditex.testapp.domain.model.Product;

public interface IPriceService {

    Price getProductPrice(Product productId, Long brandId, LocalDateTime date);

}
