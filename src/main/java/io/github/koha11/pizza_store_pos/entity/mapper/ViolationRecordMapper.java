package io.github.koha11.pizza_store_pos.entity.mapper;

import io.github.koha11.pizza_store_pos.entity.employee.Employee;
import io.github.koha11.pizza_store_pos.entity.timesheet.WorkShift;
import io.github.koha11.pizza_store_pos.entity.violation.Violation;
import io.github.koha11.pizza_store_pos.entity.violation.ViolationRecord;
import io.github.koha11.pizza_store_pos.entity.violation.ViolationRecordDTO;
import io.github.koha11.pizza_store_pos.entity.violation.ViolationRecordRequest;
import io.github.koha11.pizza_store_pos.service.EmployeeService;
import io.github.koha11.pizza_store_pos.service.ViolationService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class ViolationRecordMapper {
    @Autowired
    protected EmployeeService employeeService;

    @Mapping(source = "empId", target = "empName", qualifiedByName = "getEmpName")
    @Mapping(source = "empId", target = "empTypeName", qualifiedByName = "getEmpTypeName")
    @Mapping(source = "empId", target = "workShift", qualifiedByName = "getWorkShift")
    public abstract ViolationRecordDTO violationRecordToDTO(ViolationRecord violationRecord);

    @Named("getEmpName")
    protected String getEmpName(String empId) {
        return employeeService.getOne(empId).getFullName();
    }

    @Named("getEmpTypeName")
    protected String getEmpTypeName(String empId) {
        return employeeService.getOne(empId).getEmpType().getEmpTypeName();
    }

    @Named("getWorkShift")
    protected WorkShift getWorkShift(String empId) {
        Employee employee = employeeService.getOne(empId);
        return employee.getWorkShift();
    }
}
