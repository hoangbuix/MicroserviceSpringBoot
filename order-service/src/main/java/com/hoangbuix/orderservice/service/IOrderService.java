package com.hoangbuix.orderservice.service;

import com.hoangbuix.orderservice.dto.OrderRequest;
import com.hoangbuix.orderservice.entity.OrderEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hoangbui
 * @module package com.hoangbuix.orderservice.service;
 * @product SpringBootMicroservice
 * @since 29/11/2022 23:22
 **/

@Service
public interface IOrderService {
    List<OrderEntity> findAll();
    OrderEntity findById(Long id);
    void save(OrderEntity req);
    void update(OrderEntity req);
    void delete(Long id);
    Boolean existOrder(Long id);

    String placeOrder(OrderRequest orderRequest);
}
