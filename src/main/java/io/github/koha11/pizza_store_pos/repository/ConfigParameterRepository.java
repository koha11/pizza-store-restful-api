package io.github.koha11.pizza_store_pos.repository;

import io.github.koha11.pizza_store_pos.entity.food.Food;
import io.github.koha11.pizza_store_pos.entity.parameter.ConfigParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigParameterRepository extends JpaRepository<ConfigParameter, String> {
}
