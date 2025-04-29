package io.github.koha11.pizza_store_pos.service;

import io.github.koha11.pizza_store_pos.entity.food.FoodType;
import io.github.koha11.pizza_store_pos.repository.FoodTypeRepository;
import io.github.koha11.pizza_store_pos.util.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodTypeService {
    @Autowired
    private FoodTypeRepository foodTypeRepo;

    public List<FoodType> getAll() {
        return foodTypeRepo.findAll();
    }

    public void create(FoodType ft) {
        var foods = this.getAll();
        var id = IdGenerator.generateId(FoodType.class, foods.size());
        ft.setFoodTypeId(id);
        foodTypeRepo.save(ft);
    }

    public void update(String ftId, FoodType ft) {
        foodTypeRepo.save(ft);
    }

    public void delete(String ftId) {
        Optional<FoodType> ftOpt = foodTypeRepo.findById(ftId);

        ftOpt.ifPresentOrElse(foodType -> {
            foodTypeRepo.delete(foodType);
        }, () -> {
            throw new IllegalStateException("Can not found this id");
        });
    }
}
