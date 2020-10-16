package com.apex.eqp.inventory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class ProductServiceTests {

    @Autowired
    ProductService productService;

    @Test
    void shouldSaveProduct() {
        Product product = Product.builder()
                .name("product1")
                .price(10)
                .quantity(2)
                .build();

        Product savedProduct = productService.save(product);

        Product loadedProduct = productService.findById(savedProduct.getId()).orElse(null);

        Assertions.assertNotNull(loadedProduct);
        Assertions.assertNotNull(loadedProduct.id);
    }


    @Test
    void shouldUpdateProduct() {
        Product product = Product.builder()
                .name("product2")
                .price(10)
                .quantity(2)
                .build();

        Product savedProduct = productService.save(product);

        Product loadedProduct = productService.findById(savedProduct.getId()).orElse(null);

        Assertions.assertNotNull(loadedProduct);

        loadedProduct.setName("NewProduct");

        productService.save(loadedProduct);

        Assertions.assertNotNull(productService.findById(loadedProduct.getId()).orElse(null));
    }

    @Test
    @Disabled("Not Implemented")
    void shouldFilterProducts() {
        Assertions.fail();
    }
}
