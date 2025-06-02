package io.github.koha11.pizza_store_pos.entity.user;

import io.github.koha11.pizza_store_pos.entity.employee.EmpType;
import io.github.koha11.pizza_store_pos.entity.employee.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO {
    private String empId;
    private Employee emp;
    private String pwd;
    private String email;
    private Role role;
    private Timestamp lastAccess;
    private Timestamp createdAt;
}
