package com.apex.eqp.inventory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class ProductFilterTest {

    ProductFilter filter;

    @BeforeEach
    void before() {
        List<String> recalledProducts = new ArrayList<>();
        recalledProducts.add("Coke");
        recalledProducts.add("Gum");

        filter = new ProductFilter(recalledProducts);
    }

    @Test
    @Disabled("Not Implemented Yet")
    void shouldFilterProducts() {
        List<Product> products = new ArrayList<>();
        products.add(Product.builder()
                .quantity(1)
                .price(2.1)
                .name("Gum")
                .build());
        products.add(Product.builder()
                .quantity(1)
                .price(2.1)
                .name("KitKat")
                .build());

        List<Product> removeRecalled = filter.removeRecalled(products);

        Assertions.assertEquals( 1, removeRecalled.size());
        Assertions.assertEquals("KitKat" , removeRecalled.get(0).name);
    }
}
