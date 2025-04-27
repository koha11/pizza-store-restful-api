package io.github.koha11.pizza_store_pos.controller;

import io.github.koha11.pizza_store_pos.entity.employee.EmpType;
import io.github.koha11.pizza_store_pos.entity.food.FoodType;
import io.github.koha11.pizza_store_pos.repository.FoodTypeRepository;
import io.github.koha11.pizza_store_pos.service.EmpTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/emp-types")
public class EmpTypeController {
    @Autowired
    private EmpTypeService empTypeService;

    @GetMapping
    public List<EmpType> getAll() {
        return empTypeService.getAll();
    }
}
