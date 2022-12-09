package com.hoangbuix.inventoryservice.repository;

import com.hoangbuix.inventoryservice.entity.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author hoangbui
 * @module package com.hoangbuix.inventoryservice.repository;
 * @product microservice-springboot
 * @since 03/12/2022 23:28
 **/
@Repository
public interface InventoryRepository extends JpaRepository<InventoryEntity, Long> {
    List<InventoryEntity> findAllBySkuCode(String skuCode);
}
