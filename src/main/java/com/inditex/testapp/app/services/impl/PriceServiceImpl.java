package com.inditex.testapp.app.services.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inditex.testapp.app.services.IPriceService;
import com.inditex.testapp.domain.model.Price;
import com.inditex.testapp.domain.model.Product;
import com.inditex.testapp.infrastructure.persistance.PriceRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PriceServiceImpl implements IPriceService {

    @Autowired
    private PriceRepository priceRepository;

    @Override
    public Mono<Price> getProductPrice(Product productId, Long brandId, Date date) {
        Flux<Price> matchingPrices = Flux.fromIterable(priceRepository.findByProductIdAndBrandId(productId, brandId));

        return matchingPrices
                .filter(price -> date.after(price.getStartDate()) && date.before(price.getEndDate()))
                .reduce((selectedPrice, currentPrice) -> currentPrice.getPriority() > selectedPrice.getPriority()
                        ? currentPrice
                        : selectedPrice);
    }

}
