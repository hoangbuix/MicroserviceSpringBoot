package com.hoangbuix.productservice.service;

import com.hoangbuix.productservice.dto.ProductRequest;
import com.hoangbuix.productservice.dto.ProductResponse;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hoangbui
 * @module package com.hoangbuix.productservice.service;
 * @product microservice-springboot
 * @since 03/12/2022 23:40
 **/
@Service
public interface IProductService {
    List<ProductResponse> getAllProducts();
    void createProduct(ProductRequest productRequest);
}
