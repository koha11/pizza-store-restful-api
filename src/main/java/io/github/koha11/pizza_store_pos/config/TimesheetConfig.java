package io.github.koha11.pizza_store_pos.config;

import io.github.koha11.pizza_store_pos.entity.timesheet.Timesheet;
import io.github.koha11.pizza_store_pos.entity.violation.Violation;
import io.github.koha11.pizza_store_pos.entity.violation.ViolationRecord;
import io.github.koha11.pizza_store_pos.repository.TimesheetRepository;
import io.github.koha11.pizza_store_pos.repository.ViolationRecordRepository;
import io.github.koha11.pizza_store_pos.repository.ViolationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class TimesheetConfig {
    @Bean
    CommandLineRunner commandLineRunnerForTimesheet(TimesheetRepository timesheetRepo) {
        return args -> {
            Timesheet ts1 = new Timesheet("EMP001" , LocalDate.parse("2025-04-27"), false,  "F1", 8, 0, Timestamp.valueOf(LocalDateTime.now()));

            Timesheet ts2 = new Timesheet("EMP002", LocalDate.parse("2025-04-27"), false,"P1", 8, 0, Timestamp.valueOf(LocalDateTime.now()));

            timesheetRepo.saveAll(List.of(ts1,ts2));
        };
    }
}
