package io.github.koha11.pizza_store_pos.service;

import io.github.koha11.pizza_store_pos.entity.employee.Employee;
import io.github.koha11.pizza_store_pos.entity.employee.EmployeeRequest;
import io.github.koha11.pizza_store_pos.entity.mapper.EmployeeMapper;
import io.github.koha11.pizza_store_pos.entity.user.Role;
import io.github.koha11.pizza_store_pos.repository.EmployeeRepository;
import io.github.koha11.pizza_store_pos.util.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmployeeService extends GenericService<Employee>{

    @Autowired
    EmployeeMapper mapper;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmpTypeService empTypeService;

    @Autowired
    private WorkShiftService workShiftService;

    public EmployeeService(JpaRepository<Employee, String> repo) {
        super(repo);
    }


    public List<Employee> getEmployees(){
        return employeeRepository.findAll().stream().filter(employee -> !employee.getEmpType().getEmpTypeId().equals(Role.ROLE_ADMIN.name())).toList();
    }

    public void addEmployee(EmployeeRequest employee){
        create(mapper.EmployeeRequestToEmployee(employee));
    }

    public Employee updateEmployee(EmployeeRequest employee){
       return update(employee.getEmpId(), mapper.EmployeeRequestToEmployee(employee));
    }
    @Override
    public void create(Employee t) {
        var listOfT = this.getAll();
        var id = Helper.generateId(Employee.class, listOfT.size());
        t.setEmpId(id);
        t.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
        repo.save(t);
    }

}
