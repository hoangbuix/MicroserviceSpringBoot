package com.hoangbuix.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hoangbui
 * @module package com.hoangbuix.orderservice.dto;
 * @product SpringBootMicroservice
 * @since 29/11/2022 23:20
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryResponse {
    private Long id;
    private String skuCode;
    private boolean isInStock;
}
