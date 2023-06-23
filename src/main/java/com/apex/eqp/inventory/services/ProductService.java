package com.apex.eqp.inventory.services;

import com.apex.eqp.inventory.entities.Product;
import com.apex.eqp.inventory.entities.RecalledProduct;
import com.apex.eqp.inventory.helpers.ProductFilter;
import com.apex.eqp.inventory.repositories.InventoryRepository;
import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final InventoryRepository inventoryRepository;
    private final RecalledProductService recalledProductService;

    @Transactional
    public Product save(Product product) {
        validate(product);
        return inventoryRepository.save(product);
    }

    private void validate(Product product) {
        if (product.getPrice() < 0 || product.getQuantity() < 0) {
            throw new IllegalArgumentException("Price or Quantity must be positive");
        }
    }

    public Collection<Product> getAllProduct() {
        return inventoryRepository.findAllActiveProducts();
    }

    private ProductFilter prepareFilter() {
        Set<String> recalledProductsNames = getRecalledProductsNames();
        return new ProductFilter(recalledProductsNames);
    }

    private Set<String> getRecalledProductsNames() {
        Collection<RecalledProduct> recalledProducts = recalledProductService.getAllRecalledProducts();
        return recalledProducts.stream()
            .map(RecalledProduct::getName)
            .collect(Collectors.toSet());
    }

    public Optional<Product> findById(Integer id) {
        return inventoryRepository.findById(id);
    }

    public Product updateProduct(Integer id, Product product) {
        validate(product);
        Product savedProduct = findById(id).orElseThrow(IllegalArgumentException::new);
        product.setId(savedProduct.getId());
        return inventoryRepository.save(product);
    }

    public void deleteProduct(Integer id) {
        findById(id).orElseThrow(IllegalArgumentException::new);
        inventoryRepository.deleteById(id);
    }
}
