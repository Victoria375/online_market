package com.spring.market.online_market.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import com.spring.market.online_market.entities.dto.ProductDto;
import com.spring.market.online_market.entities.Product;
import com.spring.market.online_market.repositories.ProductRepository;
import com.spring.market.online_market.services.ProductService;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
class ProductControllerTest {
    @Autowired
    WebTestClient webTestClient;

    @Autowired
    ProductService productService;
    @Autowired
    private ProductRepository productRepository;

    @Test
    void findProductById() {
        Product newProduct = productService.createNewProduct(
                new ProductDto(100L, "Test", 63)
        );

        productRepository.save(newProduct);

        Product productByHttp = webTestClient.get()
                .uri("/api/v1/products/" + newProduct.getId())
                .exchange()
                .expectStatus().isOk()
                .expectBody(Product.class)
                .returnResult()
                .getResponseBody();

        Assertions.assertEquals(newProduct.getId(), productByHttp.getId());
        Assertions.assertEquals(newProduct.getTitle(), productByHttp.getTitle());
    }

}