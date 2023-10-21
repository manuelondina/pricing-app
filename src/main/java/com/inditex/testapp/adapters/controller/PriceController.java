package com.inditex.testapp.adapters.controller;

import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.testapp.domain.model.Price;
import com.inditex.testapp.domain.model.Product;
import com.inditex.testapp.infrastructure.persistance.PriceRepository;

@RestController
@RequestMapping("/prices")
public class PriceController {

    private PriceRepository priceRepository;

    @GetMapping("/getProduct")
    public ResponseEntity<Double> getProductPrice(
            @RequestParam Long brandId,
            @RequestParam Date applicationDate,
            @RequestParam Product productId) {

        List<Price> prices = priceRepository
                .findByBrandIdAndProductIdAndStartDateBeforeAndEndDateAfterAndPriceListOrderByPriorityDesc(
                        brandId, productId, applicationDate, applicationDate, "yourPriceList");

        if (!prices.isEmpty()) {
            return ResponseEntity.ok(prices.get(0).getPrice());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
