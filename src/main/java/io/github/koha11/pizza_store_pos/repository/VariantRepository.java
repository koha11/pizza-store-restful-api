package io.github.koha11.pizza_store_pos.repository;

import io.github.koha11.pizza_store_pos.entity.variant.Variant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VariantRepository extends JpaRepository<Variant, String> {
}
