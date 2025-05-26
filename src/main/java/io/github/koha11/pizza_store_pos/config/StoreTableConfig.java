package io.github.koha11.pizza_store_pos.config;

import io.github.koha11.pizza_store_pos.entity.store_table.StoreTable;
import io.github.koha11.pizza_store_pos.entity.store_table.TableStatus;
import io.github.koha11.pizza_store_pos.repository.TableRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class StoreTableConfig {
    @Bean
    CommandLineRunner commandLineRunnerForStoreTable(TableRepository tableRepo) {
        return args -> {
            StoreTable t01 = new StoreTable("T01", TableStatus.AVAILABLE, 4, Timestamp.valueOf(LocalDateTime.now().plusMinutes(1)));
            StoreTable t02 = new StoreTable("T02", TableStatus.AVAILABLE, 2, Timestamp.valueOf(LocalDateTime.now().plusMinutes(2)));
            StoreTable t03 = new StoreTable("T03", TableStatus.AVAILABLE, 4, Timestamp.valueOf(LocalDateTime.now().plusMinutes(3)));
            StoreTable t04 = new StoreTable("T04", TableStatus.UNAVAILABLE, 8, Timestamp.valueOf(LocalDateTime.now().plusMinutes(4)));

            tableRepo.saveAll(List.of(t01, t02, t03, t04));
        };
    }
}
