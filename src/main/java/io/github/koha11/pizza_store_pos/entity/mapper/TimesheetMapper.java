package io.github.koha11.pizza_store_pos.entity.mapper;

import io.github.koha11.pizza_store_pos.entity.employee.Employee;
import io.github.koha11.pizza_store_pos.entity.order.OnTableOrder;
import io.github.koha11.pizza_store_pos.entity.order.Order;
import io.github.koha11.pizza_store_pos.entity.order.OrderStatistic;
import io.github.koha11.pizza_store_pos.entity.timesheet.Timesheet;
import io.github.koha11.pizza_store_pos.entity.timesheet.TimesheetDTO;
import io.github.koha11.pizza_store_pos.entity.timesheet.TimesheetDetail;
import io.github.koha11.pizza_store_pos.service.EmployeeService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class TimesheetMapper {

    @Autowired
    protected EmployeeService employeeService;

    @Mapping(source = "empId", target = "empName", qualifiedByName = "getEmployeeName")
    @Mapping(source = "empId", target = "empTypeName", qualifiedByName = "getEmpTypeName")
    @Mapping(source = "empId", target = "hardWorkShiftId", qualifiedByName = "getWorkShiftId")
    public abstract TimesheetDTO timesheetToDTO(Timesheet timesheet);

    public abstract TimesheetDetail timesheetToDetail(Timesheet timesheet);

    public abstract Timesheet DTOToOrder(OnTableOrder onTableOrder);

    @Named("getEmployeeName")
    protected String getEmployeeName(String employeeId) {
        if (employeeId == null) return null;
        Employee emp = employeeService.getOne(employeeId);
        return emp.getFullName();
    }
    @Named("getWorkShiftId")
    protected String getWorkShiftId(String employeeId) {
        if (employeeId == null) return null;
        Employee emp = employeeService.getOne(employeeId);
        return emp.getHardWorkShiftId();
    }
    @Named("getEmpTypeName")
    protected String getEmpTypeName(String employeeId) {
        if (employeeId == null) return null;
        Employee emp = employeeService.getOne(employeeId);
        return emp.getEmpType().getEmpTypeName();
    }
}
