package io.github.koha11.pizza_store_pos.entity.violation;

import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ViolationRecordRequest {
    private String empId;
    private Date workingDate;
    private String violationId;
    private Time violationTime;
}
