package io.github.koha11.pizza_store_pos.service;

import io.github.koha11.pizza_store_pos.entity.variant.FoodVariant;
import io.github.koha11.pizza_store_pos.repository.FoodVariantRepository;
import io.github.koha11.pizza_store_pos.util.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodVariantService extends GenericService<FoodVariant>{
    @Autowired
    FoodVariantRepository foodVariantRepo;

    public FoodVariantService(JpaRepository<FoodVariant, String> repo) {
        super(repo);
    }

    @Override
    public void create(FoodVariant t) {

    }
}
