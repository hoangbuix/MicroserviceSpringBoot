package com.hoangbuix.productservice.service;

import com.hoangbuix.productservice.dto.ProductRequest;
import com.hoangbuix.productservice.dto.ProductResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProductService {
    List<ProductResponse> getAllProducts();
    void createProduct(ProductRequest productRequest);
}
