package io.github.koha11.pizza_store_pos.config;

import io.github.koha11.pizza_store_pos.entity.violation.Violation;
import io.github.koha11.pizza_store_pos.entity.violation.ViolationRecord;
import io.github.koha11.pizza_store_pos.repository.ViolationRecordRepository;
import io.github.koha11.pizza_store_pos.repository.ViolationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Configuration
public class ViolationConfig {
    @Bean
    CommandLineRunner commandLineRunnerForViolation(ViolationRepository violationRepo, ViolationRecordRepository violationRecordRepo) {
        return args -> {
            Violation violation = new Violation("V00001", "Đi trễ quá 30 phút", 100000, Timestamp.valueOf(LocalDateTime.now()));

            ViolationRecord violationRecord = new ViolationRecord("VR0001", "EMP001", LocalDate.parse("2025-04-27"), violation, LocalTime.parse("15:30:00"), Timestamp.valueOf(LocalDateTime.now())
            );

            violationRepo.save(violation);
            violationRecordRepo.save(violationRecord);
        };
    }
}
