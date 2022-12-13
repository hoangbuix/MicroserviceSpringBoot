package com.hoangbuix.inventoryservice.entity;

import lombok.*;

import javax.persistence.*;

/**
 * @author hoangbui
 * @module package com.hoangbuix.inventoryservice.entity;
 * @product microservice-springboot
 * @since 03/12/2022 23:27
 **/
@Entity(name = "t_inventory")
@Table(name = "t_inventory")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InventoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String skuCode;
    private int quantity;

}
