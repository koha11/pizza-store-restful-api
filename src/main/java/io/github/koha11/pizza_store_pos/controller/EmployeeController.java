package io.github.koha11.pizza_store_pos.controller;

import io.github.koha11.pizza_store_pos.entity.employee.Employee;
import io.github.koha11.pizza_store_pos.entity.order.BookedSeat;
import io.github.koha11.pizza_store_pos.repository.EmployeeRepository;
import io.github.koha11.pizza_store_pos.service.EmployeeService;
import io.github.koha11.pizza_store_pos.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController extends GenericController<Employee>{
    @Autowired
    EmployeeService employeeService;

    public EmployeeController(GenericService<Employee> genericService) {
        super(genericService);
    }

    @PostMapping
    public void create(@RequestBody Employee t) {
        employeeService.create(t);
    }
}
