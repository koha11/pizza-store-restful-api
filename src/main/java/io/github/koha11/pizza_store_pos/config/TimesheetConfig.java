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

@Configuration
public class TimesheetConfig {
    @Bean
    CommandLineRunner commandLineRunnerForTimesheet(TimesheetRepository timesheetRepo) {
        return args -> {
            Timesheet timesheet = new Timesheet("EMP001", Date.valueOf("2025-04-27"), "F1", 8, 0);

            timesheetRepo.save(timesheet);
        };
    }
}
