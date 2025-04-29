package io.github.koha11.pizza_store_pos.service;

import io.github.koha11.pizza_store_pos.entity.variant.Variant;
import io.github.koha11.pizza_store_pos.repository.VariantRepository;
import io.github.koha11.pizza_store_pos.util.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VariantService extends GenericService<Variant>{
    public VariantService(JpaRepository<Variant, String> repo) {
        super(repo);
    }
}
