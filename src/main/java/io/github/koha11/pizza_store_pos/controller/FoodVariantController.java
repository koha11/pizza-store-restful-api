package io.github.koha11.pizza_store_pos.controller;

import io.github.koha11.pizza_store_pos.entity.variant.FoodVariant;
import io.github.koha11.pizza_store_pos.service.FoodVariantService;
import io.github.koha11.pizza_store_pos.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/food-variants")
public class FoodVariantController extends GenericController<FoodVariant>{
    @Autowired
    FoodVariantService foodVariantService;

    public FoodVariantController(GenericService<FoodVariant> genericService) {
        super(genericService);
    }

    @PostMapping
    public void create(@RequestBody FoodVariant t) {
        foodVariantService.create(t);
    }
}
