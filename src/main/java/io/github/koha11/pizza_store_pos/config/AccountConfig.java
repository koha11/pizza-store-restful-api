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
            Account account1 = new Account("EMP001", "khoatran.96204@gmail.com", "1", Role.EMPLOYEE, Timestamp.valueOf(LocalDateTime.now()), Timestamp.valueOf(LocalDateTime.now()));
            Account account2 = new Account("EMP006", "admin123@gmail.com", "admin123", Role.ADMIN, Timestamp.valueOf(LocalDateTime.now()), Timestamp.valueOf(LocalDateTime.now()));
            accountRepo.saveAll(List.of(account1, account2) );
        };
    }
}
