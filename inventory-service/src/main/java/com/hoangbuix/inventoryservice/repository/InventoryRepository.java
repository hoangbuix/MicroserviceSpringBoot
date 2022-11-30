package com.hoangbuix.inventoryservice.repository;

import com.hoangbuix.inventoryservice.enity.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository  extends JpaRepository<InventoryEntity, Long> {
    List<InventoryEntity> findAllBySkuCode(String skuCode);

}
