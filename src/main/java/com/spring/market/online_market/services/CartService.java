package com.spring.market.online_market.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.spring.market.online_market.dto.Cart;
import com.spring.market.online_market.entities.Product;
import com.spring.market.online_market.exceptions.ResourceNotFoundException;

import javax.annotation.PostConstruct;

@Service
@RequiredArgsConstructor
public class CartService {
    private final ProductService productService;
    private Cart tempCart;

    @PostConstruct
    public void init() {
        tempCart = new Cart();
    }

    public Cart getCurrentCart() {
        return tempCart;
    }

    public void add(Long productId) {
        Product product = productService.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Не удается добавить продукт с id: " + productId + " в корзину. Продукт не найден"));
        tempCart.add(product);
    }
}
