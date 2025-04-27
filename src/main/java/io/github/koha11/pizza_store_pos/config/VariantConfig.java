package io.github.koha11.pizza_store_pos.config;

import io.github.koha11.pizza_store_pos.entity.variant.FoodVariant;
import io.github.koha11.pizza_store_pos.entity.variant.Variant;
import io.github.koha11.pizza_store_pos.repository.FoodVariantRepository;
import io.github.koha11.pizza_store_pos.repository.VariantRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VariantConfig {
    @Bean
    CommandLineRunner commandLineRunnerForVariant(VariantRepository variantRepo, FoodVariantRepository foodVariantRepo) {
        return args -> {
            Variant sizeS = new Variant("SIZE_M", "Medium Size (M)", 30000);

            FoodVariant pizzaHasSizeM = new FoodVariant("FT0001", "SIZE_M");

            variantRepo.save(sizeS);
            foodVariantRepo.save(pizzaHasSizeM);
        };
    }
}
