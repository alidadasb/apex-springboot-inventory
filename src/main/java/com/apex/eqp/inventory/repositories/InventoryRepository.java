package com.apex.eqp.inventory.repositories;

import com.apex.eqp.inventory.entities.Product;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface InventoryRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT p FROM Product p WHERE not exists (select rp from RecalledProduct rp where rp.name = p.name)")
    Collection<Product> findAllActiveProducts();
}
