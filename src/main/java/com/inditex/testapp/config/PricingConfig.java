package com.inditex.testapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class PricingConfig {

    @Bean
    public OpenAPI usersMicroserviceOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Pricing Application")
                        .description(
                                "Inditex test application for pricing, need to send a request to /prices/getProduct with the product and the date requested to get the final Price")
                        .version("1.0"));
    }
}
