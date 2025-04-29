package io.github.koha11.pizza_store_pos.config;

import io.github.koha11.pizza_store_pos.entity.food.Food;
import io.github.koha11.pizza_store_pos.entity.food.FoodType;
import io.github.koha11.pizza_store_pos.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class FoodConfig {
    @Bean
    CommandLineRunner commandLineRunnerForFood(FoodRepository foodRepo, FoodTypeRepository foodTypeRepo) {
        return args -> {
            FoodType pizza = new FoodType("FT0001", "Pizza", "");
            Food peperoni = new Food("F00001", "FT0001", "Peperoni", "","Italian sausages, mozzarella.", 135000);

            Food margherita = new Food("F00002", "FT0001", "Margherita", "", "A classic pizza originating in Naples Italy: Tomato sauce and mozzarella.", 98000);

            foodTypeRepo.save(pizza);
            foodRepo.saveAll(List.of(peperoni, margherita));
        };
    }
}
