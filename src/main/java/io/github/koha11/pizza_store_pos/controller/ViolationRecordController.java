package io.github.koha11.pizza_store_pos.controller;

import io.github.koha11.pizza_store_pos.entity.violation.ViolationRecord;
import io.github.koha11.pizza_store_pos.entity.violation.ViolationRecordRequest;
import io.github.koha11.pizza_store_pos.service.GenericService;
import io.github.koha11.pizza_store_pos.service.ViolationRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
    public List<ViolationRecord> getAllByDate(@PathVariable LocalDate date) {
        return violationRecordService.getVRByDate(date);
    }

    @GetMapping("/get-all-by-emp-id/{empId}")
    public List<ViolationRecord> getAllByDate(@PathVariable String empId, @RequestParam LocalDate sd, @RequestParam LocalDate ed) {
        return violationRecordService.getEmpVR(empId, sd, ed);
    }

    @PostMapping
    public void create(@RequestBody ViolationRecordRequest t) {
        violationRecordService.create(t);
    }
}
