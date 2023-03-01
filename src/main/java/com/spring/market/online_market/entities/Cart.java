package com.spring.market.online_market.entities;

import com.spring.market.online_market.entities.CartItem;
import com.spring.market.online_market.entities.dto.ProductDto;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
public class Cart {
    private List<CartItem> items;
    private int totalPrice;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public List<CartItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public void add(Product product) {
        for (CartItem item : items) {
            if (product.getId().equals(item.getProductId())) {
                item.incrementQuantity();
                recalculate();
                return;
            }
        }
        items.add(new CartItem(product));
        recalculate();
    }

    public void recalculate() {
        totalPrice = 0;
        for (CartItem item : items) {
            totalPrice += item.getPrice();
        }
    }

    public void clear() {
        items.clear();
        recalculate();
    }

}
