package io.github.koha11.pizza_store_pos.repository;

import io.github.koha11.pizza_store_pos.entity.violation.Violation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViolationRepository extends JpaRepository<Violation, String> {
}
