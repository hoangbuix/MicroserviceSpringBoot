package com.hoangbuix.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author hoangbui
 * @module package com.hoangbuix.orderservice.dto;
 * @product microservice-springboot
 * @since 03/12/2022 23:13
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    private List<OrderLineItemsDto> lineItemsDto;
}
