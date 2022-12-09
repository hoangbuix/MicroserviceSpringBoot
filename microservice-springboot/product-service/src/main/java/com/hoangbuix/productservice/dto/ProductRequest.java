package com.hoangbuix.productservice.dto;

import lombok.*;

import java.math.BigDecimal;

/**
 * @author hoangbui
 * @module package com.hoangbuix.productservice.dto;
 * @product microservice-springboot
 * @since 03/12/2022 23:41
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    private String name;
    private String description;
    private BigDecimal price;
}
