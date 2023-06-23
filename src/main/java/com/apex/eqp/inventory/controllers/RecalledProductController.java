package com.apex.eqp.inventory.controllers;

import com.apex.eqp.inventory.entities.RecalledProduct;
import com.apex.eqp.inventory.services.RecalledProductService;
import java.util.Collection;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/inventory/recalled")
public class RecalledProductController {

    private final RecalledProductService recalledProductService;

    @PostMapping
    public RecalledProduct createProduct(@RequestBody RecalledProduct recalledProduct) {
        return recalledProductService.save(recalledProduct);
    }

    @GetMapping
    Collection<RecalledProduct> findRecallProducts() {
        return recalledProductService.getAllRecalledProducts();
    }
}
