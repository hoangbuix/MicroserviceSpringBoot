package com.hoangbuix.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author hoangbui
 * @module package com.hoangbuix.orderservice.dto;
 * @product microservice-springboot
 * @since 03/12/2022 23:14
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderLineItemsDto {
    private Long id;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;
}
