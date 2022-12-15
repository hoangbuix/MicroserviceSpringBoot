package com.hoangbuix.orderservice.service.impl;

import brave.Span;
import brave.Tracer;
import com.hoangbuix.orderservice.dto.InventoryResponse;
import com.hoangbuix.orderservice.dto.OrderLineItemsDto;
import com.hoangbuix.orderservice.dto.OrderRequest;
import com.hoangbuix.orderservice.entity.OrderEntity;
import com.hoangbuix.orderservice.entity.OrderLineItem;
import com.hoangbuix.orderservice.repository.OrderRepository;
import com.hoangbuix.orderservice.service.IOrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
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
    private final WebClient.Builder webClient;
    private final Tracer tracer;

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
            if (exist) {
                throw new DuplicateKeyException("exist data");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(OrderEntity req) {
        try {
            boolean exist = orderRepository.existsById(req.getId());
            if (exist) {
                orderRepository.save(req);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        try {
            orderRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Boolean existOrder(Long id) {
        return orderRepository.existsById(id);
    }

    @Override
    public String placeOrder(OrderRequest orderRequest) {
        OrderEntity order = new OrderEntity();
        order.setOrderNumber(UUID.randomUUID().toString());
        List<OrderLineItem> orderLineItems = orderRequest.getLineItemsDto()
                .stream()
                .map(this::mapDto)
                .collect(Collectors.toList());
        order.setOrderLineItems(orderLineItems);
        List<String> skuCode = order.getOrderLineItems().stream()
                .map(orderLineItem -> orderLineItem.getSkuCode())
                .collect(Collectors.toList());

        log.info("Calling inventory service");

        Span inventoryServiceLockup = tracer.nextSpan().name("InventoryServiceLockup");

        try(Tracer.SpanInScope isLookup = tracer.withSpanInScope(inventoryServiceLockup.start())) {


            // call inventory service, and place order is product is in stock
            InventoryResponse[] inventoryResponseArr = webClient.build().get()
                    .uri("http://localhost:8080/api/v1/inventory/is-in-stock",
                            uriBuilder -> uriBuilder.queryParam("skuCode", skuCode).build())
                    .retrieve().bodyToMono(InventoryResponse[].class).block();
            boolean result = Arrays.stream(Objects.requireNonNull(inventoryResponseArr)).allMatch(InventoryResponse::isInStock);
            if (result) {
                orderRepository.save(order);
                return "Order placed Successfully";
            } else {
                throw new IllegalArgumentException("product is not in stock, please try again later");
            }
        } finally {
            inventoryServiceLockup.flush();
        }
    }

    private OrderLineItem mapDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItem orderLineItem = new OrderLineItem();
        orderLineItem.setPrice(orderLineItemsDto.getPrice());
        orderLineItem.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItem.setSkuCode(orderLineItemsDto.getSkuCode());
        return orderLineItem;
    }
}
