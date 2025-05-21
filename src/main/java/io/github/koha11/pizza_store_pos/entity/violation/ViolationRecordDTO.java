package io.github.koha11.pizza_store_pos.entity.violation;

import io.github.koha11.pizza_store_pos.entity.timesheet.WorkShift;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ViolationRecordDTO {
    private String violationRecordId;
    private String empId;
    private String empName;
    private String empTypeName;
    private WorkShift workShift;
    private LocalDate workingDate;
    private Violation violation;
    private LocalTime violationTime;
    private Timestamp createdAt;
}
