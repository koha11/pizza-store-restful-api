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

    @ManyToOne
    @JoinColumn(name = "emp_type_id",
            foreignKey = @ForeignKey(name = "fk_employee_emp_type"))
    private EmpType empType;
    private String hardWorkShiftId;
    private String fullName;
    private String address;
    private String phone;
    private String cccd;
    private Date dob;
    private Date firstDayWork;
    private Timestamp createdAt;
}
