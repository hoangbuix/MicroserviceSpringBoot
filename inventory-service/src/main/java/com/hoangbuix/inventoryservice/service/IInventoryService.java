package com.hoangbuix.inventoryservice.service;

import com.hoangbuix.inventoryservice.dto.InventoryResponse;

import java.util.List;

public interface IInventoryService {
    List<InventoryResponse> isInStock(List<String> skuCode);

}
