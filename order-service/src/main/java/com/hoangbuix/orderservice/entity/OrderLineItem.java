package com.hoangbuix.orderservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author hoangbui
 * @module package com.hoangbuix.orderservice.entity;
 * @product SpringBootMicroservice
 * @since 29/11/2022 23:19
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "order_line_item")
@Table(name = "order_line_item")
public class OrderLineItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;
}
