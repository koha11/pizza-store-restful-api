package io.github.koha11.pizza_store_pos.controller;

import io.github.koha11.pizza_store_pos.entity.food.FoodType;
import io.github.koha11.pizza_store_pos.service.FoodTypeService;
import io.github.koha11.pizza_store_pos.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food-types")
public class FoodTypeController extends GenericController<FoodType>{
    @Autowired
    private FoodTypeService foodTypeService;

    public FoodTypeController(GenericService<FoodType> genericService) {
        super(genericService);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void create(@RequestBody FoodType t) {
        foodTypeService.create(t);
    }

}
