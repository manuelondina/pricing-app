package com.inditex.testapp.app.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ResponseDTO implements Serializable {

    private Long productId;

    private Long brandId;

    private Integer priceList;

    private Date applicationDate;

    private Double finalPrice;

    private String currency;

}
