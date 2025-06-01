package io.github.koha11.pizza_store_pos.entity.employee;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequest {
    private String empId;
    private String empTypeId;
    private String workShiftId;
    private String fullName;
    private String address;
    private String phone;
    private String cccd;
    private Date dob;
}
