package io.github.koha11.pizza_store_pos.repository;


import io.github.koha11.pizza_store_pos.entity.parameter.ConfigParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConfigParameterRepository extends JpaRepository<ConfigParameter, String> {
    @Query("select cf from ConfigParameter cf where cf.paramType = :type")
    List<ConfigParameter> findAllByTpe(String type);
}
