package com.hoangbuix.inventoryservice.enity;

import jakarta.persistence.*;
import lombok.*;

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
