package io.github.koha11.pizza_store_pos.service;

import io.github.koha11.pizza_store_pos.entity.variant.Variant;
import io.github.koha11.pizza_store_pos.repository.VariantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VariantService {
    @Autowired
    VariantRepository variantRepo;

    public List<Variant> getAll() {
        return variantRepo.findAll();
    }
}
