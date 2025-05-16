package io.github.koha11.pizza_store_pos.entity.mapper;

import io.github.koha11.pizza_store_pos.entity.employee.Employee;
import io.github.koha11.pizza_store_pos.entity.order.OnTableOrder;
import io.github.koha11.pizza_store_pos.entity.order.OnTableOrderDetail;
import io.github.koha11.pizza_store_pos.entity.order.Order;
import io.github.koha11.pizza_store_pos.entity.order.OrderStatistic;
import io.github.koha11.pizza_store_pos.service.EmployeeService;
import io.github.koha11.pizza_store_pos.service.OrderDetailService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class OrderMapper {
    @Autowired
    protected EmployeeService employeeService;

    @Autowired
    protected OrderDetailService orderDetailService;

    @Mapping(source = "orderId", target = "foods", qualifiedByName = "getFoods")
    public abstract OnTableOrder orderToDTO(Order order);

    @Mapping(source = "serverId", target = "serverName", qualifiedByName = "getEmployeeName")
    @Mapping(source = "cashierId", target = "cashierName", qualifiedByName = "getEmployeeName")
    @Mapping(source = "orderId", target = "foods", qualifiedByName = "getFoods")
    public abstract OrderStatistic orderToStatistic(Order order);

    public abstract Order DTOToOrder(OnTableOrder onTableOrder);

    @Named("getEmployeeName")
    protected String getEmployeeName(String employeeId) {
        if (employeeId == null) return null;
        Employee emp = employeeService.getOne(employeeId);
        return emp.getFullName();
    }

    @Named("getFoods")
    protected List<OnTableOrderDetail> getFoods(String orderId) {
        return orderDetailService.getAllByOrderId(orderId);
    }
}
