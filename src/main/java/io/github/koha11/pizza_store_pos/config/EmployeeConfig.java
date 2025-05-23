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
import java.util.List;

@Configuration
public class EmployeeConfig {
    @Bean
    CommandLineRunner commandLineRunnerForEmp(EmpTypeRepository empTypeRepository, WorkShiftRepository workShiftRepository, EmployeeRepository employeeRepository) {
        return args -> {
            WorkShift f1 = new WorkShift("F1", "Morning fixed shift", Time.valueOf("10:00:00"), Time.valueOf("18:00:00"), Timestamp.valueOf(LocalDateTime.now()));

            WorkShift f2 = new WorkShift("F2", "Evening fixed shift", Time.valueOf("14:00:00"), Time.valueOf("22:00:00"), Timestamp.valueOf(LocalDateTime.now()));



            EmpType cashier = new EmpType("CASHIER", "Cashier",30000, 10000000, Timestamp.valueOf(LocalDateTime.now()));

            EmpType server = new EmpType("SERVER", "Server", 30000, 5000000, Timestamp.valueOf(LocalDateTime.now()));

            EmpType cooker = new EmpType("CHEF", "Chef",50000, 8000000, Timestamp.valueOf(LocalDateTime.now()));

            EmpType admin = new EmpType("ADMIN", "Admin",0, 0, Timestamp.valueOf(LocalDateTime.now()));

            Employee khoa = new Employee("EMP001",cashier, f1, "Trần Anh Khoa", "Ngoc Hiep ward, Nha Trang city", "0123456789",  "056121212123",
                    Date.valueOf("2004-06-09"),
                    Date.valueOf("2025-04-27"),
                    Timestamp.valueOf(LocalDateTime.now())
            );

            Employee vinh = new Employee("EMP002",server, f2, "Khanh Vinh", "Gam Cau ward, Nha Trang city", "0123456789",  "056121212111",
                    Date.valueOf("2004-06-09"),
                    Date.valueOf("2025-04-27"),
                    Timestamp.valueOf(LocalDateTime.now())
            );

            Employee hieu = new Employee("EMP003",cooker, f1, "Tran Anh Hieu", "Ngoc Hiep ward, Nha Trang city", "0123456789",  "056121212141",
                    Date.valueOf("2004-06-09"),
                    Date.valueOf("2025-04-27"),
                    Timestamp.valueOf(LocalDateTime.now())
            );

            Employee tam = new Employee("EMP004", cooker, f2, "Tran Anh Tam", "Ngoc Hiep ward, Nha Trang city", "0123456789",  "056121212141",
                    Date.valueOf("2004-06-09"),
                    Date.valueOf("2025-04-27"),
                    Timestamp.valueOf(LocalDateTime.now())
            );

            Employee trung = new Employee("EMP005",cashier, f1, "Tran Anh Trung", "Ngoc Hiep ward, Nha Trang city", "0123456789",  "056121212141",
                    Date.valueOf("2004-06-09"),
                    Date.valueOf("2025-04-27"),
                    Timestamp.valueOf(LocalDateTime.now())
            );

            Employee Admin = new Employee("EMP006",admin, null, "Admin", null, null,  null,
                    Date.valueOf("2004-06-09"),
                    Date.valueOf("2025-04-27"),
                    Timestamp.valueOf(LocalDateTime.now())
            );

            workShiftRepository.saveAll(List.of(f1, f2));
            empTypeRepository.saveAll(List.of(cashier, server, cooker, admin));
            employeeRepository.saveAll(List.of(khoa, vinh, hieu, tam, trung, Admin));
        };
    }
}
