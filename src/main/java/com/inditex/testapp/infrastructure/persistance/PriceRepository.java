package com.inditex.testapp.infrastructure.persistance;

import java.util.List;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import com.inditex.testapp.domain.model.Price;
import com.inditex.testapp.domain.model.Product;

@Repository
public interface PriceRepository extends R2dbcRepository<Price, Long> {

    List<Price> findByProductIdAndBrandId(Product productId, Long brandId);

}