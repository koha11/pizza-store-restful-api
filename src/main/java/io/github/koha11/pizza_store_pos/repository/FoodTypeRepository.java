package io.github.koha11.pizza_store_pos.repository;

import io.github.koha11.pizza_store_pos.entity.food.FoodType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodTypeRepository extends JpaRepository<FoodType, String> {}
