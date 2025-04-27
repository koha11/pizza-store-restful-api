package io.github.koha11.pizza_store_pos.controller;

import io.github.koha11.pizza_store_pos.entity.variant.FoodVariant;
import io.github.koha11.pizza_store_pos.service.FoodVariantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/food-variants")
public class FoodVariantController {
    @Autowired
    FoodVariantService foodVariantService;

    @GetMapping
    List<FoodVariant> getAll() {
        return foodVariantService.getAll();
    }
}
