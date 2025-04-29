package io.github.koha11.pizza_store_pos.controller;

import io.github.koha11.pizza_store_pos.entity.food.FoodType;
import io.github.koha11.pizza_store_pos.service.FoodTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food-types")
public class FoodTypeController {
    @Autowired
    private FoodTypeService foodTypeService;

    @GetMapping
    public List<FoodType> getAll() {
        return foodTypeService.getAll();
    }

    @PostMapping
    public void create(@RequestBody FoodType ft) {
        foodTypeService.create(ft);
    }

    @PutMapping("/edit/{ftId}")
    public void update(@PathVariable String ftId ,@RequestBody FoodType ft) {
        foodTypeService.update(ftId, ft);
    }

    @DeleteMapping("/delete/{ftId}")
    public void delete(@PathVariable String ftId) {
        foodTypeService.delete(ftId);
    }
}
