package com.hoangbuix.orderservice.controller;

import com.hoangbuix.orderservice.dto.OrderRequest;
import com.hoangbuix.orderservice.entity.OrderEntity;
import com.hoangbuix.orderservice.service.IOrderService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

/**
 * @author hoangbui
 * @module package com.hoangbuix.orderservice.controller;
 * @product microservice-springboot
 * @since 03/12/2022 23:19
 **/
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/order")
public class OrderController {
    private final IOrderService iOrderService;


    @GetMapping("/find-all")
    private ResponseEntity<?> findAll(){
        return new ResponseEntity<>(iOrderService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/place-order")
    @ResponseStatus(HttpStatus.CREATED)
    @CircuitBreaker(name = "inventory", fallbackMethod = "fallbackMethod")
    private CompletableFuture<String> placeOrder(@RequestBody OrderRequest orderRequest){
       return CompletableFuture.supplyAsync(()-> iOrderService.placeOrder(orderRequest));
    }

    public CompletableFuture<String> fallbackMethod(OrderRequest orderRequest, RuntimeException runtimeException) {
        return CompletableFuture.supplyAsync(() -> "Opps! Something went wrong, please order after some time!");
    }


    @PostMapping("/createdOrUpdated")
    private ResponseEntity<?> saveUser(@RequestBody OrderEntity req){
        boolean exist = iOrderService.existOrder(req.getId());
        if (!exist) {
            iOrderService.save(req);
        } else {
            iOrderService.update(req);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
