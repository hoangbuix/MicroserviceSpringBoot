package com.hoangbuix.inventoryservice.service.impl;

import com.hoangbuix.inventoryservice.dto.InventoryResponse;
import com.hoangbuix.inventoryservice.repository.InventoryRepository;
import com.hoangbuix.inventoryservice.service.IInventoryService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
/**
 * @author hoangbui
 * @module package com.hoangbuix.inventoryservice.service.impl;
 * @product microservice-springboot
 * @since 03/12/2022 23:26
 **/
@RequiredArgsConstructor
@Slf4j
@Service
public class InventoryServiceImpl implements IInventoryService {
    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    @SneakyThrows
    @Override
    public List<InventoryResponse> isInStock(List<String> skuCode) {
        List<InventoryResponse> responseList = null;
        for (String w : skuCode){
            responseList = inventoryRepository.findAllBySkuCode(w).stream().map(inventory->
                    InventoryResponse.builder()
                            .skuCode(inventory.getSkuCode())
                            .isStock(inventory.getQuantity() > 0)
                            .build()
            ).collect(Collectors.toList());
        }
        return responseList;
    }
}
