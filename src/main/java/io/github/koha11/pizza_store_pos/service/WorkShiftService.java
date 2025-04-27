package io.github.koha11.pizza_store_pos.service;

import io.github.koha11.pizza_store_pos.entity.timesheet.WorkShift;
import io.github.koha11.pizza_store_pos.repository.WorkShiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkShiftService {
    @Autowired
    private WorkShiftRepository workShiftRepo;

    public List<WorkShift> getAll() {
        return workShiftRepo.findAll();
    }
}
