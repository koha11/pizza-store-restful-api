package io.github.koha11.pizza_store_pos.controller;

import io.github.koha11.pizza_store_pos.entity.salary.Salary;
import io.github.koha11.pizza_store_pos.service.GenericService;
import io.github.koha11.pizza_store_pos.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Month;
import java.util.List;

@RestController
@RequestMapping("/salary")
public class SalaryController {
    @Autowired
    private SalaryService salaryService;

    @GetMapping()
    public List<Salary> getSalaryByMonthYear(@RequestParam Month month, @RequestParam int year) {
        return salaryService.getSalaryByMonthYear(month,year);
    }
    @PostMapping("/init")
    public void initSalary(@RequestParam Month month, @RequestParam int year) {
        salaryService.initSalarySheet(month,year);
    }

}
