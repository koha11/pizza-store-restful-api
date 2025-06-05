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
            StoreTable t04 = new StoreTable("T04", TableStatus.AVAILABLE, 6, Timestamp.valueOf(LocalDateTime.now().plusMinutes(4)));
            StoreTable t05 = new StoreTable("T05", TableStatus.AVAILABLE, 4, Timestamp.valueOf(LocalDateTime.now().plusMinutes(5)));
            StoreTable t06 = new StoreTable("T06", TableStatus.AVAILABLE, 6, Timestamp.valueOf(LocalDateTime.now().plusMinutes(6)));
            StoreTable t07 = new StoreTable("T07", TableStatus.UNAVAILABLE, 4, Timestamp.valueOf(LocalDateTime.now().plusMinutes(7)));
            StoreTable t08 = new StoreTable("T08", TableStatus.AVAILABLE, 4, Timestamp.valueOf(LocalDateTime.now().plusMinutes(8)));
            StoreTable t09 = new StoreTable("T09", TableStatus.AVAILABLE, 2, Timestamp.valueOf(LocalDateTime.now().plusMinutes(9)));
            StoreTable t10 = new StoreTable("T10", TableStatus.AVAILABLE, 8, Timestamp.valueOf(LocalDateTime.now().plusMinutes(10)));

            tableRepo.saveAll(List.of(t01, t02, t03, t04, t05, t06, t07, t08, t09, t10));
        };
    }
}
