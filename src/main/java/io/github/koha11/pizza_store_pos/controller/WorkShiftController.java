package io.github.koha11.pizza_store_pos.controller;

import io.github.koha11.pizza_store_pos.entity.timesheet.WorkShift;
import io.github.koha11.pizza_store_pos.service.GenericService;
import io.github.koha11.pizza_store_pos.service.WorkShiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/work-shifts")
public class WorkShiftController extends GenericController<WorkShift>{
    @Autowired
    private WorkShiftService workShiftService;

    public WorkShiftController(GenericService<WorkShift> genericService) {
        super(genericService);
    }

    @PostMapping("/new")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public void create(@RequestBody WorkShift workShift) {
        workShiftService.create(workShift);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public WorkShift update(@PathVariable String id, @RequestBody WorkShift workShift) {
        return workShiftService.update(id, workShift);
    }
}
