package com.hoangbuix.productservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

/**
 * @author hoangbui
 * @module package com.hoangbuix.productservice.entity;
 * @product microservice-springboot
 * @since 03/12/2022 23:37
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(value = "product")
public class ProductEntity {
    @Id
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
}
