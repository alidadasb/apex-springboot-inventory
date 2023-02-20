package com.apex.eqp.inventory.repositories;

import com.apex.eqp.inventory.entities.RecalledProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RecalledProductRepository extends JpaRepository<RecalledProduct, Integer> {}
