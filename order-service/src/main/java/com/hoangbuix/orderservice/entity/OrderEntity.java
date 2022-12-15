package com.hoangbuix.orderservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * @author hoangbui
 * @module package com.hoangbuix.orderservice.entity;
 * @product SpringBootMicroservice
 * @since 29/11/2022 23:17
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
