package io.github.koha11.pizza_store_pos.service;

import io.github.koha11.pizza_store_pos.entity.food.Food;
import io.github.koha11.pizza_store_pos.repository.FoodRepository;
import io.github.koha11.pizza_store_pos.repository.FoodTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {
    @Autowired
    private FoodRepository foodRepo;
    @Autowired
    private FoodTypeRepository foodTypeRepo;

    public List<Food> getAll() {
        return foodRepo.findAll();
    }
}
