package io.github.koha11.pizza_store_pos.controller;

import io.github.koha11.pizza_store_pos.entity.employee.EmpType;
import io.github.koha11.pizza_store_pos.entity.food.Food;
import io.github.koha11.pizza_store_pos.entity.food.FoodType;
import io.github.koha11.pizza_store_pos.repository.FoodTypeRepository;
import io.github.koha11.pizza_store_pos.service.EmpTypeService;
import io.github.koha11.pizza_store_pos.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp-types")
public class EmpTypeController extends GenericController<EmpType>{
    @Autowired
    private EmpTypeService empTypeService;

    public EmpTypeController(GenericService<EmpType> genericService) {
        super(genericService);
    }

    @PostMapping
    public void create(@RequestBody EmpType t) {
        empTypeService.create(t);
    }

    @PutMapping("/{id}")
    public EmpType update(@PathVariable String id, EmpType t) {
        return empTypeService.update(id, t);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        empTypeService.delete(id);
    }

}
