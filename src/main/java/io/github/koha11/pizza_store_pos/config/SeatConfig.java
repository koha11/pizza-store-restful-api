package io.github.koha11.pizza_store_pos.config;

import io.github.koha11.pizza_store_pos.entity.employee.EmpType;
import io.github.koha11.pizza_store_pos.entity.employee.Employee;
import io.github.koha11.pizza_store_pos.entity.seat.Seat;
import io.github.koha11.pizza_store_pos.entity.seat.SeatStatus;
import io.github.koha11.pizza_store_pos.entity.timesheet.WorkShift;
import io.github.koha11.pizza_store_pos.repository.EmpTypeRepository;
import io.github.koha11.pizza_store_pos.repository.EmployeeRepository;
import io.github.koha11.pizza_store_pos.repository.SeatRepository;
import io.github.koha11.pizza_store_pos.repository.WorkShiftRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class SeatConfig {
    @Bean
    CommandLineRunner commandLineRunnerForSeat(SeatRepository seatRepo) {
        return args -> {
            Seat t01 = new Seat("T01", SeatStatus.AVAILABLE, 4, Timestamp.valueOf(LocalDateTime.now()));
            Seat t02 = new Seat("T02", SeatStatus.AVAILABLE, 2, Timestamp.valueOf(LocalDateTime.now()));
            Seat t03 = new Seat("T03", SeatStatus.AVAILABLE, 4, Timestamp.valueOf(LocalDateTime.now()));
            Seat t04 = new Seat("T04", SeatStatus.UNAVAILABLE, 8, Timestamp.valueOf(LocalDateTime.now()));

            seatRepo.saveAll(List.of(t01, t02, t03, t04));
        };
    }
}
