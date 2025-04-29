package io.github.koha11.pizza_store_pos.controller;

import io.github.koha11.pizza_store_pos.entity.food.Food;
import io.github.koha11.pizza_store_pos.entity.variant.Variant;
import io.github.koha11.pizza_store_pos.service.GenericService;
import io.github.koha11.pizza_store_pos.service.VariantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/variants")
public class VariantController extends GenericController<Variant>{
    @Autowired
    VariantService variantService;

    public VariantController(GenericService<Variant> genericService) {
        super(genericService);
    }

    @PostMapping
    public void create(@RequestBody Variant f) {
        variantService.create(f);
    }
}
