package com.hoangbuix.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author hoangbui
 * @module package com.hoangbuix.orderservice.dto;
 * @product SpringBootMicroservice
 * @since 29/11/2022 23:21
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
