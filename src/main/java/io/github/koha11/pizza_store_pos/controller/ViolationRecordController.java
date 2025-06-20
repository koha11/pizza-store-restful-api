package io.github.koha11.pizza_store_pos.controller;

import io.github.koha11.pizza_store_pos.entity.violation.ViolationRecord;
import io.github.koha11.pizza_store_pos.entity.violation.ViolationRecordDTO;
import io.github.koha11.pizza_store_pos.entity.violation.ViolationRecordRequest;
import io.github.koha11.pizza_store_pos.service.GenericService;
import io.github.koha11.pizza_store_pos.service.ViolationRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/violation-records")
public class ViolationRecordController extends GenericController<ViolationRecord>{
    @Autowired
    private ViolationRecordService violationRecordService;

    public ViolationRecordController(GenericService<ViolationRecord> genericService) {
        super(genericService);
    }

    @GetMapping("/get-all-by-date/{date}")
    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    public List<ViolationRecord> getAllByDate(@PathVariable LocalDate date) {
        return violationRecordService.getVRByDate(date);
    }

    @GetMapping("/get-all-by-emp-id/{empId}")
    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    public List<ViolationRecord> getAllByDate(@PathVariable String empId, @RequestParam LocalDate sd, @RequestParam LocalDate ed) {
        return violationRecordService.getEmpVR(empId, sd, ed);
    }

    @GetMapping("/employee")
    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    public List<ViolationRecordDTO> getAllByMonthYear(@RequestParam Month month, @RequestParam int year) {
        return violationRecordService.getAllVRByMonthYear(month, year);
    }


    @GetMapping("/employee/{empId}")
    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    public List<ViolationRecord> getByEmpIdAndWorkingDate(@PathVariable String empId, @RequestParam LocalDate workingDate) {
        return violationRecordService.getVRByEmpIdAndWorkingDate(empId, workingDate);
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    public void create(@RequestBody List<ViolationRecordRequest> t) {
        violationRecordService.create(t);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    public void delete(@PathVariable String id) {
        violationRecordService.delete(id);
    }
}
