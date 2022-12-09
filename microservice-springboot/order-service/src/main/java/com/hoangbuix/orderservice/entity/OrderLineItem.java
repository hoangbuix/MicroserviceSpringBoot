package com.hoangbuix.orderservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
/**
 * @author hoangbui
 * @module package com.hoangbuix.orderservice.entity;
 * @product microservice-springboot
 * @since 03/12/2022 23:12
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
