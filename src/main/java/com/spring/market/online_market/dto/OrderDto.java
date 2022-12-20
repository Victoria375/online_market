package com.spring.market.online_market.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import com.spring.market.online_market.entities.Order;

import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class OrderDto {
    private Long id;
    private String description;
    private int price;

    public OrderDto(Order order) {
        this.id = order.getId();
        this.price = order.getPrice();
        this.description = order.getItems().stream().map(o -> o.getProduct().getTitle() + " x" + o.getQuantity()).collect(Collectors.joining(", "));
    }
}
