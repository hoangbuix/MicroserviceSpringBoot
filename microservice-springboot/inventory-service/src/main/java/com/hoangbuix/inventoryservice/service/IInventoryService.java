package com.hoangbuix.inventoryservice.service;

import com.hoangbuix.inventoryservice.dto.InventoryResponse;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hoangbui
 * @module package com.hoangbuix.inventoryservice.service;
 * @product microservice-springboot
 * @since 03/12/2022 23:25
 **/
@Service
public interface IInventoryService {
    List<InventoryResponse> isInStock(List<String> skuCode);
}
