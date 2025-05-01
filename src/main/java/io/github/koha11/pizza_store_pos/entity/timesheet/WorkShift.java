package io.github.koha11.pizza_store_pos.entity.timesheet;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "work_shifts")
@Entity
public class WorkShift {
    @Id
    private String workShiftId;
    private String workShiftName;
    private Time startTime;
    private Time endTime;
    private Timestamp createdAt;
}
