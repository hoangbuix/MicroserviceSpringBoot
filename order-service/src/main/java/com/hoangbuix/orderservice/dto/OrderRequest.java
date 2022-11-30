package com.hoangbuix.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author hoangbui
 * @module package com.hoangbuix.orderservice.dto;
 * @product SpringBootMicroservice
 * @since 29/11/2022 23:21
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    private List<OrderLineItemsDto> lineItemsDto;
}
