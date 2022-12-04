package com.hoangbuix.productservice.repository;

import com.hoangbuix.productservice.entity.ProductEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author hoangbui
 * @module package com.hoangbuix.productservice.repository;
 * @product microservice-springboot
 * @since 03/12/2022 23:37
 **/
@Repository
public interface ProductRepository extends MongoRepository<ProductEntity, String> {
}
