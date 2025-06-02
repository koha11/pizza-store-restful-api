package io.github.koha11.pizza_store_pos.entity.mapper;

import io.github.koha11.pizza_store_pos.entity.employee.EmpType;
import io.github.koha11.pizza_store_pos.entity.employee.Employee;
import io.github.koha11.pizza_store_pos.entity.employee.EmployeeRequest;
import io.github.koha11.pizza_store_pos.entity.timesheet.WorkShift;
import io.github.koha11.pizza_store_pos.service.EmpTypeService;
import io.github.koha11.pizza_store_pos.service.WorkShiftService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class EmployeeMapper {

    @Autowired
    protected EmpTypeService empTypeService;

    @Autowired
    protected WorkShiftService workShiftService;

    @Mapping(source = "empTypeId", target = "empType", qualifiedByName = "getEmpType")
    @Mapping(source = "workShiftId", target = "workShift", qualifiedByName = "getWorkShift")
    public abstract Employee EmployeeRequestToEmployee(EmployeeRequest employee);

    @Named("getEmpType")
    protected EmpType getEmpType(String empTypeId) {
        if(empTypeId == null) return null;
        return empTypeService.getOne(empTypeId);
    }

    @Named("getWorkShift")
    protected WorkShift getWorkShift(String workShiftId) {
        if(workShiftId == null) return null;
        return workShiftService.getOne(workShiftId);
    }
}
