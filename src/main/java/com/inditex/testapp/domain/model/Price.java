package com.inditex.testapp.domain.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import reactor.core.publisher.Flux;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("prices")
public class Price {

    @Id
    private Long id;

    @Column("brand_id")
    private Long brandId;

    @MappedCollection(idColumn = "product_id")
    private Flux<Product> productId;

    @Column("start_date")
    private Date startDate;

    @Column("end_date")
    private Date endDate;

    @Column("price_list")
    private Integer priceList;

    private Integer priority;

    private Double price;

    @Column("curr")
    private String currency;
}
