package io.github.koha11.pizza_store_pos.controller;

import io.github.koha11.pizza_store_pos.entity.timesheet.Timesheet;
import io.github.koha11.pizza_store_pos.service.GenericService;
import io.github.koha11.pizza_store_pos.service.TimesheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/timesheets")
public class TimesheetController extends GenericController<Timesheet>{
    @Autowired
    private TimesheetService timesheetService;

    public TimesheetController(GenericService<Timesheet> genericService) {
        super(genericService);
    }

    @PostMapping
    public void create(@RequestBody Timesheet t) {
        timesheetService.create(t);
    }
}
