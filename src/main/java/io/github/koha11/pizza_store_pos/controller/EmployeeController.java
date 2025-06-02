package io.github.koha11.pizza_store_pos.controller;

import io.github.koha11.pizza_store_pos.entity.employee.Employee;
import io.github.koha11.pizza_store_pos.entity.employee.EmployeeRequest;
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


    @GetMapping("/dto")
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }

    @PostMapping("/dto")
    public void addEmployee(@RequestBody EmployeeRequest employee){
         employeeService.addEmployee(employee);
    }

    @PostMapping
    public void create(@RequestBody Employee t) {
        employeeService.create(t);
    }

    @PutMapping("/dto")
    public Employee update(@RequestBody EmployeeRequest employee){
        return employeeService.updateEmployee(employee);
    }
}
