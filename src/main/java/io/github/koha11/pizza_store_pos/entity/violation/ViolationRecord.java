package io.github.koha11.pizza_store_pos.entity.violation;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "violation_records")
@Entity
public class ViolationRecord {
    @Id
    private String violationRecordId;
    private String empId;
    private Date workingDate;
    private String violationId;
    private Time violationTime;
    private Timestamp createdAt;
}
