package io.github.koha11.pizza_store_pos.service;

import io.github.koha11.pizza_store_pos.entity.employee.EmpType;
import io.github.koha11.pizza_store_pos.entity.employee.Employee;
import io.github.koha11.pizza_store_pos.entity.parameter.ConfigParameter;
import io.github.koha11.pizza_store_pos.entity.salary.Salary;
import io.github.koha11.pizza_store_pos.entity.timesheet.Timesheet;
import io.github.koha11.pizza_store_pos.entity.violation.ViolationRecord;
import io.github.koha11.pizza_store_pos.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
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

    @Autowired
    private ConfigParameterRepository configParameterRepo;

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
                    int OTSalaryInWorkingDay = calculateOTSalary(salary.getEmpType().getBasicSalary(), ts.getOvertimeWorkingHours(),  ts.getWorkingDate());
                    int salaryInWorkingDay = calculateSalary(salary.getEmpType().getBasicSalary(),  ts.getWorkingDate());
                    int dailySalary = salaryInWorkingDay + OTSalaryInWorkingDay;
                    salary.setTotalSalary(salary.getTotalSalary() + dailySalary);
                    salary.setTotalOTSalary(salary.getTotalOTSalary() + OTSalaryInWorkingDay);

                } else {
                    salary.setTotalOffDay(salary.getTotalOffDay() + 1);
                }
            }
            salary.setTotalOvertimeWorkingHours(salary.getTotalOvertimeWorkingHours() + ts.getOvertimeWorkingHours());
            int totalFine = violationRecords.stream()
                    .mapToInt(vr -> vr.getViolation().getViolationFine())
                    .sum();

//            int OTSalaryInWorkingDay = calculateOTSalary(salary.getEmpType().getBasicSalary(), ts.getOvertimeWorkingHours(),  ts.getWorkingDate());
//            int salaryInWorkingDay = calculateSalary(salary.getEmpType().getBasicSalary(),  ts.getWorkingDate());


            salary.setTotalFine(totalFine);



        }
        salaryRepo.saveAll(new ArrayList<>(salaryMap.values()));
    }

    public List<Salary> getSalaryByMonthYear(Month month, int year) {
        return salaryRepo.findAllByMonthYear(month, year);
    }



    private double getMultiplier(LocalDate workingDay, String type) {
        List<ConfigParameter> holidays = configParameterRepo.findAllByTpe("Holiday");
        for (ConfigParameter param : holidays) {
            String val = param.getParamValue();
            boolean isMatched = false;

            if (val.startsWith("--")) {
                String md = workingDay.format(DateTimeFormatter.ofPattern("MM-dd"));
                isMatched = val.substring(2).equals(md);
            } else if (val.length() == 10) {
                isMatched = LocalDate.parse(val).equals(workingDay);
            }

            if (isMatched) {
                if (param.getParamType().equalsIgnoreCase("Tet") && type.equalsIgnoreCase("Tet")) {
                    return 3.0;
                } else if (param.getParamType().equalsIgnoreCase("Holiday") && type.equalsIgnoreCase("Holiday")) {
                    return 3.0;
                }
            }
        }
        return type.equalsIgnoreCase("Holiday") ? 1.0 : 1.5;
    }

    public int calculateOTSalary(int basicSalary, int OT, LocalDate workingDay) {
        double hoursSalary = (double) basicSalary / (26 * 8);
        double multiplierOT = getMultiplier(workingDay, "OT");
        double otSalary = hoursSalary * OT * multiplierOT;
        return (int) Math.round(otSalary);
    }


    public int calculateSalary(int basicSalary, LocalDate workingDay) {
        double hoursSalary = (double) basicSalary / (26 * 8);
        double multiplier = getMultiplier(workingDay, "Holiday");

        double regularSalary = hoursSalary * 8 * multiplier;

        return (int) Math.round(regularSalary);
    }

}
