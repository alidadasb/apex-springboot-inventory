package com.apex.eqp.inventory.recalledproduct;

import com.apex.eqp.inventory.Product;
import com.apex.eqp.inventory.ProductFilter;
import com.apex.eqp.inventory.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/inventory/recalled")
public class RecalledProductController {

    private final RecalledProductService recalledProductService;

    @PostMapping
    public ResponseEntity<RecalledProduct> createProduct(@RequestBody RecalledProduct recalledProduct) {
        return ResponseEntity.ok(recalledProductService.save(recalledProduct));
    }

    @GetMapping("/")
    ResponseEntity<Collection<RecalledProduct>> findRecallProducts() {
        Collection<RecalledProduct> allRecalledProducts = recalledProductService.getAllRecalledProducts();

        return ResponseEntity.ok(allRecalledProducts);
    }
}
