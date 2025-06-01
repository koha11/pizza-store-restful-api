package io.github.koha11.pizza_store_pos.service;

import io.github.koha11.pizza_store_pos.entity.food.Food;
import io.github.koha11.pizza_store_pos.entity.food.FoodDTO;
import io.github.koha11.pizza_store_pos.entity.mapper.FoodMapper;
import io.github.koha11.pizza_store_pos.repository.FoodRepository;
import io.github.koha11.pizza_store_pos.util.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class FoodService extends GenericService<Food>{
    @Autowired
    private FoodRepository foodRepo;

    @Autowired
    private FoodMapper mapper;

    @Autowired
    private FoodTypeService foodTypeService;

    public FoodService(JpaRepository<Food, String> repo, FoodRepository foodRepo) {
        super(repo);
        this.foodRepo = foodRepo;
    }

    public List<FoodDTO> getFoodDTOs() {
        List<Food> foods = foodRepo.findAll();
        return foods.stream().map(food -> mapper.FoodToDTO(food)).toList();
    }


    @Override
    public void create(Food t) {
        var listOfT = this.getAll();
        var id = Helper.generateId(Food.class, listOfT.size());
        t.setFoodId(id);
        t.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
        repo.save(t);
    }


    public Food updateFood(Food t, String id) {
       Food f = repo.findById(id).orElse(null);
       if(f == null) {
           return null;
       }
       f.setFoodName(t.getFoodName());
       f.setDescription(t.getDescription());
       f.setPrice(t.getPrice());
       f.setFoodImage(t.getFoodImage());
       f.setFoodTypeId(t.getFoodTypeId());
       repo.save(f);
       return f;
    }

}
