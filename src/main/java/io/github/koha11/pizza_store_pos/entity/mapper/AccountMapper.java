package io.github.koha11.pizza_store_pos.entity.mapper;

import io.github.koha11.pizza_store_pos.entity.employee.EmpType;
import io.github.koha11.pizza_store_pos.entity.employee.Employee;
import io.github.koha11.pizza_store_pos.entity.user.Account;
import io.github.koha11.pizza_store_pos.entity.user.AccountDTO;
import io.github.koha11.pizza_store_pos.service.EmployeeService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class AccountMapper {

    @Autowired
    protected EmployeeService employeeService;

    @Mapping(source = "empId", target = "emp", qualifiedByName = "getEmployee")
    public abstract AccountDTO accountToAccountDTO(Account account);

    @Named("getEmployee")
    protected Employee getEmployee(String empId) {
        if(empId == null) return null;
        return employeeService.getOne(empId);
    }


}
