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
    public ResponseEntity<ResponseDTO> getProductPrice(
            @RequestParam Long brandId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date applicationDate,
            @RequestParam Long productId) {

        // Retrieve the Product entity using the product ID
        Product product = productService.getProductById(productId);

        // Retrieve the Price entity using the product ID, brand ID and application date
        Price getProductPrice = dateRangeService.getProductPrice(product, brandId, applicationDate);

        if (getProductPrice != null) {
            ResponseDTO responseDTO = responseService.buildResponseDTO(productId, brandId, applicationDate,
                    getProductPrice.getPriceList(),
                    getProductPrice.getPrice(), getProductPrice.getCurrency());
            return ResponseEntity.ok(responseDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

}
