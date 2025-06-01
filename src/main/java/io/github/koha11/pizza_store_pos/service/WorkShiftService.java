package io.github.koha11.pizza_store_pos.service;

import io.github.koha11.pizza_store_pos.entity.timesheet.WorkShift;
import io.github.koha11.pizza_store_pos.repository.WorkShiftRepository;
import io.github.koha11.pizza_store_pos.util.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class WorkShiftService extends GenericService<WorkShift>{

    public WorkShiftService(JpaRepository<WorkShift, String> repo) {
        super(repo);
    }

    @Override
    public void create(WorkShift workShift) {
        workShift.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
        super.create(workShift);
    }

    @Override
    public WorkShift update(String id, WorkShift workShift) {
        workShift.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
        return super.update(id, workShift);
    }

    public int getWSWorkingTime(String workShiftId) {
        if(workShiftId == null)
            return 0;

        WorkShift ws = getOne(workShiftId);

        long startTime = ws.getStartTime().getTime();

        long endTime = ws.getEndTime().getTime();


        return (int) (endTime - startTime)/(1000 * 60 * 60);
    }
}
