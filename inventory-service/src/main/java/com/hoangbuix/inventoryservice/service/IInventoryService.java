package com.hoangbuix.inventoryservice.service;

import com.hoangbuix.inventoryservice.dto.InventoryResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IInventoryService {
    List<InventoryResponse> isInStock(List<String> skuCode);

}
