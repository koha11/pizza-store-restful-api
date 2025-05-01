package io.github.koha11.pizza_store_pos.entity.mapper;

import io.github.koha11.pizza_store_pos.entity.employee.Employee;
import io.github.koha11.pizza_store_pos.entity.order.OnTableOrder;
import io.github.koha11.pizza_store_pos.entity.order.Order;
import io.github.koha11.pizza_store_pos.entity.order.OrderStatistic;
import io.github.koha11.pizza_store_pos.service.EmployeeService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class OrderMapper {
    @Autowired
    protected EmployeeService employeeService;

    public abstract OnTableOrder orderToDTO(Order order);

    @Mapping(source = "serverId", target = "serverName", qualifiedByName = "getEmployeeName")
    @Mapping(source = "cashierId", target = "cashierName", qualifiedByName = "getEmployeeName")
    public abstract OrderStatistic orderToStatistic(Order order);
    public abstract Order DTOToOrder(OnTableOrder onTableOrder);

    @Named("getEmployeeName")
    protected String getEmployeeName(String employeeId) {
        Employee emp = employeeService.getOne(employeeId);
        return emp != null ? emp.getFullName() : "";
    }
}
