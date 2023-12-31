package com.inditex.testapp.infrastructure.persistance;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.inditex.testapp.domain.model.Price;
import com.inditex.testapp.domain.model.Product;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long>, JpaSpecificationExecutor<Price> {
    List<Price> findByProductIdAndBrandId(Product productId, Long brandId);
}