package io.github.koha11.pizza_store_pos.repository;

import io.github.koha11.pizza_store_pos.entity.variant.Variant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VariantRepository extends JpaRepository<Variant, String> {
    @Query("SELECT v from Variant v join FoodVariant fv on fv.foodTypeId = :ftId  ")
    List<Variant> findByFoodTypeId(@Param("ftId") String foodTypeId);
}
