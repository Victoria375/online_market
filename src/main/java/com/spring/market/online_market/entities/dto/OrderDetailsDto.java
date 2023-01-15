package com.spring.market.online_market.entities.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderDetailsDto {

    private String phone;

    private DeliveryAddressDto deliveryAddress;

}
