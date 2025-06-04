package io.github.koha11.pizza_store_pos.config;

import io.github.koha11.pizza_store_pos.entity.parameter.ConfigParameter;
import io.github.koha11.pizza_store_pos.entity.store_table.StoreTable;
import io.github.koha11.pizza_store_pos.entity.store_table.TableStatus;
import io.github.koha11.pizza_store_pos.repository.TableRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class ParamConfig {
    @Bean
    CommandLineRunner commandLineRunnerForConfigParam(JpaRepository<ConfigParameter, String> repo) {
        return args -> {
            ConfigParameter param1 = new ConfigParameter("P00001", "Phụ thu tự động", "Tiền", "20000", true, Timestamp.valueOf(LocalDateTime.now()));

            repo.saveAll(List.of(param1));
        };
    }
}

