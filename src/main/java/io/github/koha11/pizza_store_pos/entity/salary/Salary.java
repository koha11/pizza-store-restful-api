package io.github.koha11.pizza_store_pos.entity.salary;

import io.github.koha11.pizza_store_pos.entity.employee.EmpType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Month;

@Table(name = "salary")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(SalaryId.class)
public class Salary {
    @Id
    private String empId;
    private String empName;
    private String workShiftName;
    @ManyToOne
    private EmpType empType;
    @Id
    private Month month;
    @Id
    private int year;
    private int totalWorkingDay;
    private int totalOvertimeWorkingHours;
    private int totalFine;
    private int totalOffDay;
    private int totalSalary;
}

