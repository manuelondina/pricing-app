package com.inditex.testapp.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class PricingConfig {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public OpenAPI usersMicroserviceOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Pricing Application")
                        .description(
                                "Inditex test application for pricing, need to send a request to /prices/getProduct with the product and the date requested to get the final Price")
                        .version("1.0"));
    }

    // XXXBean configuration for CORS filter for the case of running a front end
    // application, then uncomment the following lines:
    // @Bean
    // public CorsFilter corsFilter() {
    // CorsConfiguration corsConfiguration = new CorsConfiguration();
    // corsConfiguration.setAllowCredentials(true);
    // corsConfiguration
    // .setAllowedOrigins(
    // Arrays.asList("http://localhost:4200"));
    // corsConfiguration.setAllowedHeaders(Arrays.asList("*"));
    // corsConfiguration.setExposedHeaders(Arrays.asList("*"));
    // corsConfiguration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE",
    // "OPTIONS", "PATCH", "DELETE"));
    // UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new
    // UrlBasedCorsConfigurationSource();
    // urlBasedCorsConfigurationSource.registerCorsConfiguration("/**",
    // corsConfiguration);
    // return new CorsFilter(urlBasedCorsConfigurationSource);
    // }

}
