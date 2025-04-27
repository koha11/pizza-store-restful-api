package io.github.koha11.pizza_store_pos.config;

import io.github.koha11.pizza_store_pos.entity.variant.FoodVariant;
import io.github.koha11.pizza_store_pos.entity.variant.Variant;
import io.github.koha11.pizza_store_pos.entity.violation.Violation;
import io.github.koha11.pizza_store_pos.entity.violation.ViolationRecord;
import io.github.koha11.pizza_store_pos.repository.FoodVariantRepository;
import io.github.koha11.pizza_store_pos.repository.VariantRepository;
import io.github.koha11.pizza_store_pos.repository.ViolationRecordRepository;
import io.github.koha11.pizza_store_pos.repository.ViolationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Date;
import java.sql.Time;

@Configuration
public class ViolationConfig {
    @Bean
    CommandLineRunner commandLineRunnerForViolation(ViolationRepository violationRepo, ViolationRecordRepository violationRecordRepo) {
        return args -> {
            Violation violation = new Violation("V00001", "Đi trễ quá 30 phút", 100000);

            ViolationRecord violationRecord = new ViolationRecord("VR0001", "EMP001", Date.valueOf("2025-04-27"), "V00001", Time.valueOf("15:30:00")
            );

            violationRepo.save(violation);
            violationRecordRepo.save(violationRecord);
        };
    }
}
