package io.github.koha11.pizza_store_pos.entity.timesheet;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class TimesheetId implements Serializable {
    private String empId;
    private LocalDate workingDate;
}
