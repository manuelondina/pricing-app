package com.inditex.testapp.app.services;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.inditex.testapp.app.dto.ResponseDTO;

@Service
public class ResponseService {

    public ResponseDTO buildResponseDTO(Long productId, Long brandId, Date applicationDate, Integer priceList,
            Double price, String currency) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setProductId(productId);
        responseDTO.setBrandId(brandId);
        responseDTO.setApplicationDate(applicationDate);
        responseDTO.setPriceList(priceList);
        responseDTO.setFinalPrice(price);
        responseDTO.setCurrency(currency);

        return responseDTO;
    }
}
