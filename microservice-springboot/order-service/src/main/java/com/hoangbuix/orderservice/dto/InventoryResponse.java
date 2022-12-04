package com.hoangbuix.orderservice.dto;

import lombok.*;

/**
 * @author hoangbui
 * @module package com.hoangbuix.orderservice.dto;
 * @product microservice-springboot
 * @since 03/12/2022 23:14
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryResponse {
    private String skuCode;
    private boolean isInStock;
}
