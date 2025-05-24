package io.github.koha11.pizza_store_pos.config;

import io.github.koha11.pizza_store_pos.entity.food.Food;
import io.github.koha11.pizza_store_pos.entity.food.FoodType;
import io.github.koha11.pizza_store_pos.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class FoodConfig {
    @Bean
    CommandLineRunner commandLineRunnerForFood(FoodRepository foodRepo, FoodTypeRepository foodTypeRepo) {
        return args -> {
            FoodType pizza = new FoodType("FT0001", "Pizza", "https://ilmio.vn/uploads/fnb-menu/pizza/giant-pizza-size42cm.jpg", Timestamp.valueOf(LocalDateTime.now()));

            FoodType desert = new FoodType("FT0002", "Desert", "https://ilmio.vn/uploads/fnb-menu/pizza/giant-pizza-size42cm.jpg", Timestamp.valueOf(LocalDateTime.now()));

            Food peperoni = new Food("F00001", "FT0001", "Peperoni", "https://ilmio.vn/uploads/fnb-menu/pizza/pizza-pepperoni.jpg","Italian sausages, mozzarella.", 135000, Timestamp.valueOf(LocalDateTime.now()));

            Food margherita = new Food("F00002", "FT0002", "Margherita", "https://ilmio.vn/uploads/fnb-menu/pizza/pizza-margherita.jpg", "A classic pizza originating in Naples Italy: Tomato sauce and mozzarella.", 98000, Timestamp.valueOf(LocalDateTime.now()));

            foodTypeRepo.saveAll(List.of(pizza, desert));
            foodRepo.saveAll(List.of(peperoni, margherita));
        };
    }
}
