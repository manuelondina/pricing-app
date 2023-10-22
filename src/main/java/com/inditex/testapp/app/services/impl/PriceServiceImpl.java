package com.inditex.testapp.app.services.impl;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inditex.testapp.app.services.IPriceService;
import com.inditex.testapp.domain.model.Price;
import com.inditex.testapp.domain.model.Product;
import com.inditex.testapp.infrastructure.persistance.PriceRepository;

@Service
public class PriceServiceImpl implements IPriceService {

    @Autowired
    private PriceRepository priceRepository;

    @Override
    public Price getProductPrice(Product productId, Long brandId, LocalDateTime date) {
        List<Price> productPrices = priceRepository.findByProductIdAndBrandId(productId, brandId);

        return productPrices.stream()
                .filter(d -> d.getStartDate().isBefore(date) && d.getEndDate().isAfter(date))
                .max(Comparator.comparing(Price::getPriceList).thenComparing(Price::getPriority))
                .orElse(null);
    }
}
