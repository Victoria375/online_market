package com.spring.market.online_market.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.spring.market.online_market.dto.OrderDetailsDto;
import com.spring.market.online_market.dto.OrderDto;
import com.spring.market.online_market.entities.User;
import com.spring.market.online_market.services.OrderService;
import com.spring.market.online_market.services.UserService;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/orders")
public class OrderController {
    private final OrderService orderService;
    private final UserService userService;

    @PostMapping
    public void createNewOrder(Principal principal,
                               @RequestBody OrderDetailsDto orderDetailsDto) {
        User user = userService.findByUsername(principal.getName()).get();
        orderService.createOrderForCurrentUser(user, orderDetailsDto);
    }

    @GetMapping
    public List<OrderDto> getAllOrdersForCurrentUser(Principal principal) {
        User user = userService.findByUsername(principal.getName()).get();
        return orderService.findAllByUser(user).stream().map(OrderDto::new).collect(Collectors.toList());
    }


}
