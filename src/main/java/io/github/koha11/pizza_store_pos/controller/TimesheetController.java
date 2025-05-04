package io.github.koha11.pizza_store_pos.controller;

import ch.qos.logback.classic.pattern.DateConverter;
import io.github.koha11.pizza_store_pos.entity.timesheet.Timesheet;
import io.github.koha11.pizza_store_pos.service.GenericService;
import io.github.koha11.pizza_store_pos.service.TimesheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/timesheets")
public class TimesheetController extends GenericController<Timesheet>{
    @Autowired
    private TimesheetService timesheetService;

    public TimesheetController(GenericService<Timesheet> genericService) {
        super(genericService);
    }

    @GetMapping("/get-all-by-date/{date}")
    public List<Timesheet> getAllByDate(@PathVariable LocalDate date) {
        return timesheetService.getTimesheetByDate(date);
    }

    @GetMapping("/get-all-by-month")
    public List<Timesheet> getAllByMonth(@RequestParam Month month, @RequestParam int year) {
        return timesheetService.getTimesheetByMonth(month, year);
    }

    @PostMapping
    public void create(@RequestBody Timesheet t) {
        timesheetService.create(t);
    }

    @PostMapping("/init-timesheet")
    public void initTimesheetForNextMonth() {
        LocalDate today = LocalDate.now();
        Month nextMonth = today.getMonth().plus(1);

//        if(today.getDayOfMonth() > 25)
            timesheetService.addSheetForMonth(nextMonth, today.getYear());
    }

}
