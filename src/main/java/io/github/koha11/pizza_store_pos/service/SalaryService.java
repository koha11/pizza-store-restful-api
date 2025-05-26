package io.github.koha11.pizza_store_pos.service;

import io.github.koha11.pizza_store_pos.entity.employee.EmpType;
import io.github.koha11.pizza_store_pos.entity.employee.Employee;
import io.github.koha11.pizza_store_pos.entity.salary.Salary;
import io.github.koha11.pizza_store_pos.entity.timesheet.Timesheet;
import io.github.koha11.pizza_store_pos.entity.violation.ViolationRecord;
import io.github.koha11.pizza_store_pos.repository.EmployeeRepository;
import io.github.koha11.pizza_store_pos.repository.SalaryRepository;
import io.github.koha11.pizza_store_pos.repository.TimesheetRepository;
import io.github.koha11.pizza_store_pos.repository.ViolationRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class SalaryService {

    @Autowired
    private EmployeeRepository employeeRepo;

    @Autowired
    private SalaryRepository salaryRepo;

    @Autowired
    private TimesheetRepository timesheetRepo;

    @Autowired
    private ViolationRecordRepository violationRecordRepo;

    public void initSalarySheet(Month month, int year){
        List<Salary> existingSalary = salaryRepo.findAllByMonthYear(month, year);
        if(!existingSalary.isEmpty()) {
            return;
        }
        LocalDate startDate = LocalDate.of(year,month, 1);
        LocalDate endDate = LocalDate.of(year,month, YearMonth.of(year, month).lengthOfMonth());
        List<Timesheet> timesheets = timesheetRepo.findAllByMonth(startDate, endDate);
        Map<String, Salary> salaryMap = new HashMap<>();
        for(Timesheet ts : timesheets) {
            List<ViolationRecord> violationRecords = violationRecordRepo.findAllByEmpId(ts.getEmpId(),startDate,endDate);
            Salary salary = salaryMap.get(ts.getEmpId());
            Employee emp = employeeRepo.findById(ts.getEmpId()).orElse(null);
            EmpType empType = emp.getEmpType();
            if(salary == null) {
                salary = new Salary();
                salaryMap.put(ts.getEmpId(), salary);
                salary.setEmpId(ts.getEmpId());
                salary.setEmpType(empType);
                salary.setWorkShiftName(emp.getWorkShift().getWorkShiftName());
            }
            salary.setEmpName(emp.getFullName());
            salary.setMonth(month);
            salary.setYear(year);
            if(ts.isStatus()) {
                if(ts.getWorkingHours() > 0) {
                    salary.setTotalWorkingDay(salary.getTotalWorkingDay() + 1);

                } else {
                    salary.setTotalOffDay(salary.getTotalOffDay() + 1);
                }
            }
            salary.setTotalOvertimeWorkingHours(salary.getTotalOvertimeWorkingHours() + ts.getOvertimeWorkingHours());
            int totalFine = violationRecords.stream()
                    .mapToInt(vr -> vr.getViolation().getViolationFine())
                    .sum();
            salary.setTotalFine(totalFine);
            int hoursSalary = (int) Math.round(
                    ((double) salary.getEmpType().getBasicSalary() / (26 * 8))
                            * salary.getTotalOvertimeWorkingHours()
                            * 1.5
            );

            int totalSalary = (int) Math.round((double) salary.getEmpType().getBasicSalary() + (salary.getTotalOvertimeWorkingHours() * hoursSalary) - salary.getTotalFine());
            salary.setTotalOTSalary(hoursSalary);
            salary.setTotalSalary(totalSalary);
        }
        salaryRepo.saveAll(new ArrayList<>(salaryMap.values()));
    }

    public List<Salary> getSalaryByMonthYear(Month month, int year) {
        return salaryRepo.findAllByMonthYear(month, year);
    }
}
