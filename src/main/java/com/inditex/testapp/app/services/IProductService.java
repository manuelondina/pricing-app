package com.inditex.testapp.app.services;

import com.inditex.testapp.domain.model.Product;

public interface IProductService {

    Product getProductById(Long id);

}
