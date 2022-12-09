package com.hoangbuix.inventoryservice.dto;

import lombok.*;

/**
 * @author hoangbui
 * @module package com.hoangbuix.inventoryservice.dto;
 * @product microservice-springboot
 * @since 03/12/2022 23:27
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InventoryResponse {
    private Long id;
    private String skuCode;
    private Boolean isStock;
}
