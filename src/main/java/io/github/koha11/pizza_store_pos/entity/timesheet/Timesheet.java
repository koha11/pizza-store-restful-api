package io.github.koha11.pizza_store_pos.entity.timesheet;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "timesheets")
@Entity
@IdClass(TimesheetId.class)
public class Timesheet {
    @Id
    private String empId;
    @Id
    private Date workingDate;
    private String workShiftId;
    private int workingHours;
    private int overtimeWorkingHours;
    private Timestamp createdAt;
}
