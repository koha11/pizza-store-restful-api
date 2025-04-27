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

@Configuration
public class SeatConfig {
    @Bean
    CommandLineRunner commandLineRunnerForSeat(SeatRepository seatRepo) {
        return args -> {
            Seat t1 = new Seat("T01", SeatStatus.AVAILABLE, 4);

            seatRepo.save(t1);
        };
    }
}
