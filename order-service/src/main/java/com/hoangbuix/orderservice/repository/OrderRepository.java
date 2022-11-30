package com.hoangbuix.orderservice.repository;

import com.hoangbuix.orderservice.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author hoangbui
 * @module package com.hoangbuix.orderservice.repository;
 * @product SpringBootMicroservice
 * @since 29/11/2022 23:22
 **/
@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
