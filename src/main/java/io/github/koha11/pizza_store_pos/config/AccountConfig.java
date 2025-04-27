package io.github.koha11.pizza_store_pos.config;

import io.github.koha11.pizza_store_pos.entity.order.*;
import io.github.koha11.pizza_store_pos.entity.user.Account;
import io.github.koha11.pizza_store_pos.repository.AccountRepository;
import io.github.koha11.pizza_store_pos.repository.BookedSeatRepository;
import io.github.koha11.pizza_store_pos.repository.OrderDetailRepository;
import io.github.koha11.pizza_store_pos.repository.OrderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Configuration
public class AccountConfig {
    @Bean
    CommandLineRunner commandLineRunnerForAccount(AccountRepository accountRepo) {
        return args -> {
            Account account = new Account("EMP001", "khoatran.96204@gmail.com", "1", Timestamp.valueOf(LocalDateTime.now()));

            accountRepo.save(account);
        };
    }
}
