package io.github.koha11.pizza_store_pos.repository;

import io.github.koha11.pizza_store_pos.entity.variant.FoodVariant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodVariantRepository extends JpaRepository<FoodVariant, String> {
}
