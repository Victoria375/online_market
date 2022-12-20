package com.spring.market.online_market.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.spring.market.online_market.entities.Cart;
import com.spring.market.online_market.entities.Product;
import com.spring.market.online_market.exceptions.ResourceNotFoundException;
import com.spring.market.online_market.entities.CartItem;

import javax.annotation.PostConstruct;
import java.util.List;

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
        for (CartItem cartItem : tempCart.getItems()) {
            if (cartItem.getProduct().getId().equals(productId)) {
                cartItem.incrementQuantity();
                tempCart.recalculate();
                return;
            }
        }

        Product product = productService.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product doesn't exists id: " + productId + " (add to cart)"));
        List<CartItem> cartItemList = tempCart.getItems();
        cartItemList.add(new CartItem(product));
        tempCart.recalculate();
    }
}
