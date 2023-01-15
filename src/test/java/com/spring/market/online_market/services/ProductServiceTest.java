package com.spring.market.online_market.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.spring.market.online_market.entities.dto.ProductDto;
import com.spring.market.online_market.entities.Product;
import com.spring.market.online_market.repositories.ProductRepository;

@SpringBootTest
class ProductServiceTest {
    @Autowired
    ProductService productService;

    @Autowired
    ProductRepository productRepository;

    @Test
    void createNewProduct() {
        Product product = productService.createNewProduct(
                new ProductDto( 200L, "Test", 88)
        );
        Assertions.assertNotNull(product);
        Assertions.assertNotNull(product.getId());
        Assertions.assertEquals("Test", product.getTitle());

        Product product1 = productRepository.findById(product.getId()).orElse(null);
        Assertions.assertEquals("Test", product1.getTitle());
    }

}

