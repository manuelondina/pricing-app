package com.inditex.testapp.app.services.impl;

import java.util.Date;
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
    public Price getProductPrice(Product productId, Long brandId, Date date) {
        List<Price> matchingPrices = priceRepository.findByProductIdAndBrandId(productId, brandId);

        Price selectedPrice = null;

        for (Price price : matchingPrices) {
            Date startDate = price.getStartDate();
            Date endDate = price.getEndDate();
            if (date.after(startDate) && date.before(endDate)) {
                if (selectedPrice == null || price.getPriority() > selectedPrice.getPriority()) {
                    selectedPrice = price;
                }
            }
        }

        return selectedPrice;
    }

}
