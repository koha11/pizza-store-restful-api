package io.github.koha11.pizza_store_pos.config;

import io.github.koha11.pizza_store_pos.entity.variant.FoodVariant;
import io.github.koha11.pizza_store_pos.entity.variant.Variant;
import io.github.koha11.pizza_store_pos.repository.FoodVariantRepository;
import io.github.koha11.pizza_store_pos.repository.VariantRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Configuration
public class VariantConfig {
    @Bean
    CommandLineRunner commandLineRunnerForVariant(VariantRepository variantRepo, FoodVariantRepository foodVariantRepo) {
        return args -> {
            Variant sizeS = new Variant("SIZE_M", "Medium Size (M)", 30000, Timestamp.valueOf(LocalDateTime.now()));

            FoodVariant pizzaHasSizeM = new FoodVariant("FT0001", "SIZE_M", Timestamp.valueOf(LocalDateTime.now()));

            variantRepo.save(sizeS);
            foodVariantRepo.save(pizzaHasSizeM);
        };
    }
}
