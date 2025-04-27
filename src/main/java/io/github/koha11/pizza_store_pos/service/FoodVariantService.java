package io.github.koha11.pizza_store_pos.service;

import io.github.koha11.pizza_store_pos.entity.variant.FoodVariant;
import io.github.koha11.pizza_store_pos.repository.FoodVariantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodVariantService {
    @Autowired
    FoodVariantRepository foodVariantRepo;

    public List<FoodVariant> getAll() {
        return foodVariantRepo.findAll();
    }
}
