package io.github.koha11.pizza_store_pos.controller;

import io.github.koha11.pizza_store_pos.entity.timesheet.WorkShift;
import io.github.koha11.pizza_store_pos.service.GenericService;
import io.github.koha11.pizza_store_pos.service.WorkShiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/work-shifts")
public class WorkShiftController extends GenericController<WorkShift>{
    @Autowired
    private WorkShiftService workShiftService;

    public WorkShiftController(GenericService<WorkShift> genericService) {
        super(genericService);
    }
}
