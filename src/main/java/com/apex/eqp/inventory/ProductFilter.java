package com.apex.eqp.inventory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ProductFilter {

    private final List<String> recalledProducts;

    ProductFilter(List<String> recalledProducts) {
        if (recalledProducts == null) recalledProducts = new ArrayList<>();

        this.recalledProducts = recalledProducts;
    }

    public List<Product> removeRecalled(Collection<Product> allProduct) {
        return allProduct.stream().filter(ProductFilter::filterByName).collect(Collectors.toList());
    }

    private static boolean filterByName(Product product) {
        return true;
    }
}
