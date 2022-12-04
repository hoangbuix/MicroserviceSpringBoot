package com.hoangbuix.orderservice.repository;

import com.hoangbuix.orderservice.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author hoangbui
 * @module package com.hoangbuix.orderservice.repository;
 * @product microservice-springboot
 * @since 03/12/2022 23:15
 **/
@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
