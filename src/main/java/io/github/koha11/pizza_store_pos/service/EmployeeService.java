package io.github.koha11.pizza_store_pos.service;

import io.github.koha11.pizza_store_pos.entity.employee.Employee;
import io.github.koha11.pizza_store_pos.entity.food.FoodType;
import io.github.koha11.pizza_store_pos.repository.EmployeeRepository;
import io.github.koha11.pizza_store_pos.util.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmployeeService extends GenericService<Employee>{
    @Autowired
    EmployeeRepository employeeRepository;

    public EmployeeService(JpaRepository<Employee, String> repo) {
        super(repo);
    }

    @Override
    public void create(Employee t) {
        var listOfT = this.getAll();
        var id = Helper.generateId(Employee.class, listOfT.size());
        t.setEmpId(id);
        t.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
        repo.save(t);
    }
}
