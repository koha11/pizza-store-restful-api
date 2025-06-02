package io.github.koha11.pizza_store_pos.service;

import io.github.koha11.pizza_store_pos.entity.food.FoodType;
import io.github.koha11.pizza_store_pos.repository.FoodTypeRepository;
import io.github.koha11.pizza_store_pos.util.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.function.Function;

@Service
public class FoodTypeService extends GenericService<FoodType>{
    @Autowired
    private FoodTypeRepository foodTypeRepo;

    public FoodTypeService(JpaRepository<FoodType, String> repo, FoodTypeRepository foodTypeRepo) {
        super(repo);
        this.foodTypeRepo = foodTypeRepo;
    }

    @Override
    public void create(FoodType t) {
        var listOfT = this.getAll();
        var id = Helper.generateId(FoodType.class, listOfT.size());
        t.setFoodTypeId(id);
        t.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
        repo.save(t);
    }


    @Override
    public FoodType update(String id, FoodType t) {
        t.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
        return super.update(id, t);
    }

    public void getFoodVariants(String foodId) {

    }
}
