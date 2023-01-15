package com.spring.market.online_market.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.spring.market.online_market.entities.dto.OrderDetailsDto;
import com.spring.market.online_market.entities.Order;
import com.spring.market.online_market.entities.CartItem;
import com.spring.market.online_market.entities.User;
import com.spring.market.online_market.repositories.OrderRepository;
import com.spring.market.online_market.entities.Cart;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final Cart cart;

    public List<Order> findAllByUser(User user) {
        return orderRepository.findAllByUser(user);
    }

    public Order createOrderForCurrentUser(User user, OrderDetailsDto orderDetailsDto) {
        Order order = new Order();
        order.setUser(user);
        order.setPrice(cart.getTotalPrice());
        order.setItems(cart.getItems());
        for (CartItem oi : cart.getItems()) {
            oi.setOrder(order);
        }
        order.setPhone(orderDetailsDto.getPhone());
        order.setAddress(orderDetailsDto.getDeliveryAddress().toString());
        order = orderRepository.save(order);
        cart.clear();
        return order;
    }
}
