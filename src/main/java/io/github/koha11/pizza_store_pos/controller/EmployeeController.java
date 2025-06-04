package io.github.koha11.pizza_store_pos.controller;

import io.github.koha11.pizza_store_pos.entity.employee.Employee;
import io.github.koha11.pizza_store_pos.entity.employee.EmployeeRequest;
import io.github.koha11.pizza_store_pos.service.EmployeeService;
import io.github.koha11.pizza_store_pos.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @GetMapping("/dto")
    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }

    @PostMapping("/dto")
    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    public void addEmployee(@RequestBody EmployeeRequest employee){
         employeeService.addEmployee(employee);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    public void create(@RequestBody Employee t) {
        employeeService.create(t);
    }

    @PutMapping("/dto")
    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    public Employee update(@RequestBody EmployeeRequest employee){
        return employeeService.updateEmployee(employee);
    }
}
