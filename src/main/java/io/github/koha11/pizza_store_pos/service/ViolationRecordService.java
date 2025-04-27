package io.github.koha11.pizza_store_pos.service;

import io.github.koha11.pizza_store_pos.entity.violation.ViolationRecord;
import io.github.koha11.pizza_store_pos.repository.ViolationRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViolationRecordService {
    @Autowired
    private ViolationRecordRepository violationRecordRepo;

    public List<ViolationRecord> getAll() {
        return violationRecordRepo.findAll();
    }
}
