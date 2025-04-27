package io.github.koha11.pizza_store_pos.entity.employee;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private EmpType empType;

    @ManyToOne
    private WorkShift hardWorkShift;
    private String fullName;
    private String address;
    private String phone;
    private String email;
    private String cccd;
    private Date dob;
    private Date firstDayWork;
}
