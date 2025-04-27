package io.github.koha11.pizza_store_pos.controller;

import io.github.koha11.pizza_store_pos.entity.violation.Violation;
import io.github.koha11.pizza_store_pos.service.ViolationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/violations")
public class ViolationController{
    @Autowired
    private ViolationService violationService;

    @GetMapping
    public List<Violation> getAll() {
        return violationService.getAll();
    }
}
