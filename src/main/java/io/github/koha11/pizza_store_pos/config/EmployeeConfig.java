package io.github.koha11.pizza_store_pos.config;

import io.github.koha11.pizza_store_pos.entity.employee.EmpType;
import io.github.koha11.pizza_store_pos.entity.employee.Employee;
import io.github.koha11.pizza_store_pos.entity.timesheet.WorkShift;
import io.github.koha11.pizza_store_pos.repository.EmpTypeRepository;
import io.github.koha11.pizza_store_pos.repository.EmployeeRepository;
import io.github.koha11.pizza_store_pos.repository.WorkShiftRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Configuration
public class EmployeeConfig {
    @Bean
    CommandLineRunner commandLineRunnerForEmp(EmpTypeRepository empTypeRepository, WorkShiftRepository workShiftRepository, EmployeeRepository employeeRepository) {
        return args -> {
            WorkShift f1 = new WorkShift("F1", "Ca cứng ban ngày", Time.valueOf("10:00:00"), Time.valueOf("18:00:00"), Timestamp.valueOf(LocalDateTime.now()));

            EmpType cashier = new EmpType("CASHIER", "Cashier", 7800000, Timestamp.valueOf(LocalDateTime.now()));

            Employee khoa = new Employee("EMP001",cashier, "F1", "Trần Anh Khoa", "Ngoc Hiep ward, Nha Trang city", "0123456789",  "056121212123",
                    Date.valueOf("2004-06-09"),
                    Date.valueOf("2025-04-27"),
                    Timestamp.valueOf(LocalDateTime.now())
            );

            workShiftRepository.save(f1);
            empTypeRepository.save(cashier);
            employeeRepository.save(khoa);
        };
    }
}
