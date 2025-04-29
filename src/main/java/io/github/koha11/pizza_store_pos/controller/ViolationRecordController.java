package io.github.koha11.pizza_store_pos.controller;

import io.github.koha11.pizza_store_pos.entity.violation.ViolationRecord;
import io.github.koha11.pizza_store_pos.service.GenericService;
import io.github.koha11.pizza_store_pos.service.ViolationRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/violation-records")
public class ViolationRecordController extends GenericController<ViolationRecord>{
    @Autowired
    private ViolationRecordService violationRecordService;

    public ViolationRecordController(GenericService<ViolationRecord> genericService) {
        super(genericService);
    }

    @PostMapping
    public void create(@RequestBody ViolationRecord t) {
        violationRecordService.create(t);
    }
}
