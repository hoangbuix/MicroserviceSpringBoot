package com.hoangbuix.inventoryservice.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InventoryResponse {
    private Long id;
    private String skuCode;
    private Boolean isStock;
}
