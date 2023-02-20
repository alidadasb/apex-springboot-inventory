package com.apex.eqp.inventory.repositories;

import com.apex.eqp.inventory.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InventoryRepository extends JpaRepository<Product, Integer> {}
