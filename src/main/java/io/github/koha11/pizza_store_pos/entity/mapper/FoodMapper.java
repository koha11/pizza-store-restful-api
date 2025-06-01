package io.github.koha11.pizza_store_pos.entity.mapper;

import io.github.koha11.pizza_store_pos.entity.food.Food;
import io.github.koha11.pizza_store_pos.entity.food.FoodDTO;
import io.github.koha11.pizza_store_pos.entity.food.FoodType;
import io.github.koha11.pizza_store_pos.service.FoodTypeService;
import jdk.jfr.Name;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class FoodMapper {
    @Autowired
    protected FoodTypeService foodTypeService;

    @Mapping(source = "foodTypeId", target = "foodType", qualifiedByName = "getFoodType")
    public abstract FoodDTO FoodToDTO(Food food);

    @Named("getFoodType")
    protected FoodType getFoodType(String foodTypeId) {
        if (foodTypeId == null) return null;
        return foodTypeService.getOne(foodTypeId);
    }

}
