package com.hoangbuix.inventoryservice.controller;

import com.hoangbuix.inventoryservice.dto.InventoryResponse;
import com.hoangbuix.inventoryservice.service.IInventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/inventory")
public class InventoryController {
    private final IInventoryService inventoryService;

    @GetMapping("/is-in-stock")
    @ResponseStatus(HttpStatus.OK)
    private List<InventoryResponse> isInStock(@RequestParam(name = "skuCode") List<String> skuCode) {
        return inventoryService.isInStock(skuCode);
    }
}
