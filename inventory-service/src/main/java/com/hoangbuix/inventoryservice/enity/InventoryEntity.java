package com.hoangbuix.inventoryservice.enity;

import lombok.*;

import javax.persistence.*;

@Entity(name = "inventory")
@Table(name = "inventory")
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
