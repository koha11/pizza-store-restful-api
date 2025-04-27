package io.github.koha11.pizza_store_pos.controller;

import io.github.koha11.pizza_store_pos.entity.violation.ViolationRecord;
import io.github.koha11.pizza_store_pos.service.ViolationRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/violation-records")
public class ViolationRecordController {
    @Autowired
    private ViolationRecordService violationRecordService;

    @GetMapping
    List<ViolationRecord> getAll() {
        return violationRecordService.getAll();
    }
}
