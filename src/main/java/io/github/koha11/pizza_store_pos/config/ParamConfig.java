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
            ConfigParameter param1 = new ConfigParameter("P00001", "Phụ thu tự động", "surcharge", "20000", true, Timestamp.valueOf(LocalDateTime.now()));
            ConfigParameter param2 = new ConfigParameter("P00002", "Lễ 30/4", "Holiday", "--04-30", true, Timestamp.valueOf(LocalDateTime.now()));
            ConfigParameter param3 = new ConfigParameter("P00003", "Lễ 1/5", "Holiday", "--05-01", true, Timestamp.valueOf(LocalDateTime.now()));
            ConfigParameter param4 = new ConfigParameter("P00004", "Lễ 2/9", "Holiday", "--09-02", true, Timestamp.valueOf(LocalDateTime.now()));
            ConfigParameter param5 = new ConfigParameter("P00005", "Tết 2025", "Tet", "2025-01-29", true, Timestamp.valueOf(LocalDateTime.now()));

            repo.saveAll(List.of(param1, param2, param3, param4, param5));
        };
    }
}

