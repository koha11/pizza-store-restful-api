package io.github.koha11.pizza_store_pos.entity.timesheet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShiftRegistrationRequest {
    private String empId;
    private LocalDate workingDate;
    private String workShiftId;
}
