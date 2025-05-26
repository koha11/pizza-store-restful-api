package io.github.koha11.pizza_store_pos.controller;

import ch.qos.logback.classic.pattern.DateConverter;
import io.github.koha11.pizza_store_pos.entity.timesheet.AttendanceRequest;
import io.github.koha11.pizza_store_pos.entity.timesheet.ShiftRegistrationRequest;
import io.github.koha11.pizza_store_pos.entity.timesheet.Timesheet;
import io.github.koha11.pizza_store_pos.entity.timesheet.TimesheetDTO;
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
    public List<TimesheetDTO> getAllByMonth(@RequestParam Month month, @RequestParam int year) {
        return timesheetService.getTimesheetByMonth(month, year);
    }
    @PostMapping("/attendance")
    public void attendance(@RequestBody AttendanceRequest request) {
         timesheetService.attendance(request);
    }

    @PostMapping("/attendance-all")
    public void attendanceAll() {
        timesheetService.attendanceAll();
    }

    @PostMapping("/absent")
    public void markAbsent(@RequestBody AttendanceRequest request) {
        timesheetService.markAbsent(request);
    }
    @PostMapping
    public void create(@RequestBody Timesheet t) {
        timesheetService.create(t);
    }

    @PostMapping("/init-timesheet")
    public void initTimesheet() {
        LocalDate today = LocalDate.now();
        Month currentMonth = today.getMonth();

//        if(today.getDayOfMonth() > 25)
            timesheetService.addSheetForMonth(currentMonth, today.getYear());
    }

    @PostMapping("/shift-registration")
    public void shiftRegistration(@RequestBody ShiftRegistrationRequest request) {
        timesheetService.setWorkShift(request);

    }

}
