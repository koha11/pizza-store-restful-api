package io.github.koha11.pizza_store_pos.entity.timesheet;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TimesheetDTO {
    private String empId;
    private String empName;
    private boolean status;
    private String empTypeName;
    private LocalDate workingDate;
    private WorkShift workShift;
    private int workingHours;
    private int overtimeWorkingHours;
    private Timestamp createdAt;
}
