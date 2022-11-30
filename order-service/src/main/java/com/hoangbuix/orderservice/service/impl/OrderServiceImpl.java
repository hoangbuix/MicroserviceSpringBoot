package com.hoangbuix.orderservice.service.impl;

import com.hoangbuix.orderservice.dto.InventoryResponse;
import com.hoangbuix.orderservice.dto.OrderLineItemsDto;
import com.hoangbuix.orderservice.dto.OrderRequest;
import com.hoangbuix.orderservice.entity.OrderEntity;
import com.hoangbuix.orderservice.entity.OrderLineItem;
import com.hoangbuix.orderservice.repository.OrderRepository;
import com.hoangbuix.orderservice.service.IOrderService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author hoangbui
 * @module package com.hoangbuix.orderservice.service.impl;
 * @product SpringBootMicroservice
 * @since 29/11/2022 23:23
 **/
@Component
@Slf4j
@RequiredArgsConstructor
@Transactional
public class OrderServiceImpl implements IOrderService {
    private final OrderRepository orderRepository;
    private final WebClient webClient;

    @Override
    public List<OrderEntity> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public OrderEntity findById(Long id) {
        return orderRepository.findById(id).get();
    }

    @Override
    public void save(OrderEntity req) {
        try {
            boolean exist = orderRepository.existsById(req.getId());
            if(exist) {
                throw new DuplicateKeyException("exist data");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(OrderEntity req) {
        try {
            Boolean exist = orderRepository.existsById(req.getId());
            if (exist){
                orderRepository.save(req);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        try {
            orderRepository.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Boolean existOrder(Long id) {
        return orderRepository.existsById(id);
    }

    @Override
    public void placeOrder(OrderRequest orderRequest) {
        try {
            OrderEntity order = new OrderEntity();
            order.setOrderNumber(UUID.randomUUID().toString());
            List<OrderLineItem> orderLineItems= orderRequest.getLineItemsDto()
                    .stream()
                    .map(this::mapDto)
                    .collect(Collectors.toList());
            order.setOrderLineItems(orderLineItems);

            List<String> skuCode = order.getOrderLineItems().stream().map(orderLineItem -> orderLineItem.getSkuCode()).collect(Collectors.toList());
            // call inventory service, and place order ì product is in stock
            InventoryResponse[] inventoryResponseArr = webClient.get().uri("http://localhost:8082/api/v1/inventory",
                    uriBuilder -> uriBuilder.queryParam("skuCode", skuCode).build())
                    .retrieve().bodyToMono(InventoryResponse[].class).block();
            Boolean result = Arrays.stream(inventoryResponseArr).allMatch(InventoryResponse::isInStock);
            if(result) {
                orderRepository.save(order);
            } else {
                throw new IllegalArgumentException("product is not in stock, please try again later");            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private OrderLineItem mapDto(OrderLineItemsDto orderLineItemsDto){
        OrderLineItem orderLineItem = new OrderLineItem();
        orderLineItem.setPrice(orderLineItemsDto.getPrice());
        orderLineItem.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItem.setSkuCode(orderLineItemsDto.getSkuCode());
        return orderLineItem;
    }
}
