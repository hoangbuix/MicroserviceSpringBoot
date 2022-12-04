package com.hoangbuix.orderservice.controller;

import com.hoangbuix.orderservice.dto.OrderRequest;
import com.hoangbuix.orderservice.entity.OrderEntity;
import com.hoangbuix.orderservice.service.IOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    private String placeOrder(@RequestBody OrderRequest orderRequest){
        iOrderService.placeOrder(orderRequest);
        return "Order placed Successfully";
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
