package io.github.koha11.pizza_store_pos.service;

import io.github.koha11.pizza_store_pos.entity.food.Food;
import io.github.koha11.pizza_store_pos.entity.food.FoodType;
import io.github.koha11.pizza_store_pos.repository.FoodRepository;
import io.github.koha11.pizza_store_pos.repository.FoodTypeRepository;
import io.github.koha11.pizza_store_pos.util.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FoodService extends GenericService<Food>{
    @Autowired
    private FoodRepository foodRepo;
    @Autowired
    private FoodTypeRepository foodTypeRepo;

    public FoodService(JpaRepository<Food, String> repo, FoodRepository foodRepo, FoodTypeRepository foodTypeRepo) {
        super(repo);
        this.foodRepo = foodRepo;
        this.foodTypeRepo = foodTypeRepo;
    }

    @Override
    public void create(Food t) {
        var listOfT = this.getAll();
        var id = Helper.generateId(Food.class, listOfT.size());
        t.setFoodId(id);
        repo.save(t);
    }

}
