package com.apex.eqp.inventory.services;

import com.apex.eqp.inventory.entities.RecalledProduct;
import com.apex.eqp.inventory.repositories.RecalledProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RecalledProductService {

    private final RecalledProductRepository recalledProductRepository;

    public RecalledProduct save(RecalledProduct recalledProduct) {
        return recalledProductRepository.save(recalledProduct);
    }

    public Collection<RecalledProduct> getAllRecalledProducts() {
        return recalledProductRepository.findAll();
    }

    public Optional<RecalledProduct> findById(Integer id) {
        return recalledProductRepository.findById(id);
    }
}
