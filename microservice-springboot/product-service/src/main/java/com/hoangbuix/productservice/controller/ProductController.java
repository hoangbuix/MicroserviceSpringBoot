package com.hoangbuix.productservice.controller;

import com.hoangbuix.productservice.dto.ProductRequest;
import com.hoangbuix.productservice.dto.ProductResponse;
import com.hoangbuix.productservice.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author hoangbui
 * @module package com.hoangbuix.productservice.controller;
 * @product microservice-springboot
 * @since 03/12/2022 23:43
 **/
@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final IProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest) {
        productService.createProduct(productRequest);
    }

    @GetMapping("/find-all")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }

}

