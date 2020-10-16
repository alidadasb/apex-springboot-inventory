package com.apex.eqp.inventory.recalledproduct;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RecalledProductRepository extends JpaRepository<RecalledProduct, Integer> {}
