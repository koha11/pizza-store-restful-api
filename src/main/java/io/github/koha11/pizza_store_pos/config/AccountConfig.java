package io.github.koha11.pizza_store_pos.config;

import io.github.koha11.pizza_store_pos.entity.user.Account;
import io.github.koha11.pizza_store_pos.entity.user.Role;
import io.github.koha11.pizza_store_pos.repository.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class AccountConfig {
    @Bean
    CommandLineRunner commandLineRunnerForAccount(AccountRepository accountRepo) {
        return args -> {
            Account account1 = new Account("EMP001", "khoatran.96204@gmail.com", "$2a$10$cU9bDaDldS1xTaItT.w8PurjvMQRqr.hvhMunYnC72XyHqyF6Z.WS", Role.ROLE_CASHIER, Timestamp.valueOf(LocalDateTime.now()), Timestamp.valueOf(LocalDateTime.now()));
            Account account2 = new Account("EMP002", "abc@gmail.com", "$2a$10$cU9bDaDldS1xTaItT.w8PurjvMQRqr.hvhMunYnC72XyHqyF6Z.WS", Role.ROLE_CASHIER, Timestamp.valueOf(LocalDateTime.now()), Timestamp.valueOf(LocalDateTime.now()));
            Account account3 = new Account("EMP003", "test@gmail.com", "$2a$10$cU9bDaDldS1xTaItT.w8PurjvMQRqr.hvhMunYnC72XyHqyF6Z.WS", Role.ROLE_CASHIER, Timestamp.valueOf(LocalDateTime.now()), Timestamp.valueOf(LocalDateTime.now()));
            Account account4 = new Account("EMP004", "kasdomm@gmail.com", "$2a$10$cU9bDaDldS1xTaItT.w8PurjvMQRqr.hvhMunYnC72XyHqyF6Z.WS", Role.ROLE_SERVER, Timestamp.valueOf(LocalDateTime.now()), Timestamp.valueOf(LocalDateTime.now()));
            Account account5 = new Account("EMP005", "manager@gmail.com", "$2a$10$cU9bDaDldS1xTaItT.w8PurjvMQRqr.hvhMunYnC72XyHqyF6Z.WS", Role.ROLE_MANAGER, Timestamp.valueOf(LocalDateTime.now()), Timestamp.valueOf(LocalDateTime.now()));
            Account account6 = new Account("EMP006", "admin123@gmail.com", "$2a$10$cU9bDaDldS1xTaItT.w8PurjvMQRqr.hvhMunYnC72XyHqyF6Z.WS", Role.ROLE_ADMIN, Timestamp.valueOf(LocalDateTime.now()), Timestamp.valueOf(LocalDateTime.now()));
            accountRepo.saveAll(List.of(account1, account2, account3, account4, account5, account6) );
        };
    }
}
