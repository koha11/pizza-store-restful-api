package io.github.koha11.pizza_store_pos.entity.employee;

import io.github.koha11.pizza_store_pos.entity.timesheet.WorkShift;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employees")
@Entity
public class Employee {
    @Id
    private String empId;
    private String empTypeId;
    private String hardWorkShiftId;
    private String fullName;
    private String address;
    private String phone;
    private String cccd;
    private Date dob;
    private Date firstDayWork;
}
