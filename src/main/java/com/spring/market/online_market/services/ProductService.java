package com.spring.market.online_market.services;

import com.spring.market.online_market.entities.dto.ProductDto;
import com.spring.market.online_market.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.spring.market.online_market.entities.Product;
import com.spring.market.online_market.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final IdentityMap identityMap = new IdentityMap();

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public Product findProductById(Long id) {
        Product product = this.identityMap.getProductMap(id);
        if (product != null) {
            return product;
        } else {
            product = productRepository.findById(id).orElseThrow(() ->
                    new ResourceNotFoundException("product not found"));
            if (product != null) {
                this.identityMap.addProductMap(product);
                return product;
            }
        }
        return null;
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public Product createNewProduct(ProductDto productDto) {
        Product product = Product.builder().build();
        product.setPrice(productDto.getPrice());
        product.setTitle(productDto.getTitle());
        productRepository.save(product);
        return product;
    }

}
