package io.github.koha11.pizza_store_pos.controller;

import io.github.koha11.pizza_store_pos.entity.violation.Violation;
import io.github.koha11.pizza_store_pos.service.GenericService;
import io.github.koha11.pizza_store_pos.service.ViolationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/violations")
public class ViolationController extends GenericController<Violation>{
    @Autowired
    private ViolationService violationService;

    public ViolationController(GenericService<Violation> genericService) {
        super(genericService);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    public void create(@RequestBody Violation t) {
        violationService.create(t);
    }

    @PutMapping("/{id}")
    public Violation update(@PathVariable String id, @RequestBody Violation t) {
        return violationService.update(id, t);
    }
}
