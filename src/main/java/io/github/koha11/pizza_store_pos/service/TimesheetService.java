package io.github.koha11.pizza_store_pos.service;

import io.github.koha11.pizza_store_pos.entity.timesheet.Timesheet;
import io.github.koha11.pizza_store_pos.repository.TimesheetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimesheetService extends GenericService<Timesheet>{
    @Autowired
    private TimesheetRepository timesheetRepo;

    public TimesheetService(JpaRepository<Timesheet, String> repo) {
        super(repo);
    }

    public void create() {

    }
}
