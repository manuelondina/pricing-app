package com.inditex.testapp.adapters.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.testapp.app.dto.ResponseDTO;
import com.inditex.testapp.app.services.ResponseService;
import com.inditex.testapp.app.services.impl.PriceServiceImpl;
import com.inditex.testapp.app.services.impl.ProductServiceImpl;
import com.inditex.testapp.domain.model.Price;
import com.inditex.testapp.domain.model.Product;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/prices")
public class PriceController {

    @Autowired
    private PriceServiceImpl dateRangeService;

    @Autowired
    private ProductServiceImpl productService;

    @Autowired
    private ResponseService responseService;

    @GetMapping("/getProductPrice")
    public Mono<ResponseEntity<ResponseDTO>> getProductPrice(
            @RequestParam Long brandId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date applicationDate,
            @RequestParam Long productId) {

        // Retrieve the Product entity using the product ID
        Mono<Product> productMono = productService.getProductById(productId);

        return productMono
                .flatMap(product -> {
                    // Retrieve the Price entity using the product ID, brand ID, and application
                    // date
                    Mono<Price> priceMono = dateRangeService.getProductPrice(product, brandId, applicationDate);

                    return priceMono
                            .map(getProductPrice -> {
                                ResponseDTO responseDTO = responseService.buildResponseDTO(productId, brandId,
                                        applicationDate,
                                        getProductPrice.getPriceList(),
                                        getProductPrice.getPrice(), getProductPrice.getCurrency());
                                return ResponseEntity.ok(responseDTO);
                            })
                            .defaultIfEmpty(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
                });
    }

}
