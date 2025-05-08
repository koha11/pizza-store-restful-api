package io.github.koha11.pizza_store_pos.entity.timesheet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TimesheetDetail {
    private String empId;
    private String empName;
    private String workShiftId;
    private int workingHours;
    private int overtimeWorkingHours;
}
