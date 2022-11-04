package com.microservice.orderservice.dto;

import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderLineItemsDto {
    private Long id;
    private String code;
    private BigDecimal price;
    private Integer quantity;
}
