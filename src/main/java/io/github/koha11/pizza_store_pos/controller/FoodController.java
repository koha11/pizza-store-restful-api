package io.github.koha11.pizza_store_pos.controller;

import io.github.koha11.pizza_store_pos.entity.food.Food;
import io.github.koha11.pizza_store_pos.service.FoodService;
import io.github.koha11.pizza_store_pos.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foods")
public class FoodController extends GenericController<Food>{
    @Autowired
    private FoodService foodService;

    public FoodController(GenericService<Food> genericService) {
        super(genericService);
    }

    @PostMapping
    public void create(@RequestBody Food t) {
        foodService.create(t);
    }
}
