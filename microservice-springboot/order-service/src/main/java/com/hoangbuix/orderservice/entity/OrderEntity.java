package com.hoangbuix.orderservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author hoangbui
 * @module package com.hoangbuix.orderservice.entity;
 * @product microservice-springboot
 * @since 03/12/2022 23:10
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "t_order")
@Table(name = "t_order")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderNumber;

    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderLineItem> orderLineItems;
}


