package com.hoangbuix.productservice.service.impl;

import com.hoangbuix.productservice.dto.ProductRequest;
import com.hoangbuix.productservice.dto.ProductResponse;
import com.hoangbuix.productservice.entity.ProductEntity;
import com.hoangbuix.productservice.repository.ProductRepository;
import com.hoangbuix.productservice.service.IProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author hoangbui
 * @module package com.hoangbuix.productservice.service.impl;
 * @product microservice-springboot
 * @since 03/12/2022 23:42
 **/
@Component
@AllArgsConstructor
@Slf4j
public class ProductServiceImpl implements IProductService {
    private final ProductRepository productRepository;


    @Override
    public void createProduct(ProductRequest productRequest) {
        ProductEntity product = ProductEntity.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        productRepository.save(product);
        log.info("Product {} is saved", product.getId());
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        List<ProductEntity> products = productRepository.findAll();

        return products.stream().map(this::mapToProductResponse).toList();
    }

    private ProductResponse mapToProductResponse(ProductEntity product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
