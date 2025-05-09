package io.github.koha11.pizza_store_pos.service;

import io.github.koha11.pizza_store_pos.entity.employee.Employee;
import io.github.koha11.pizza_store_pos.entity.mapper.TimesheetMapper;
import io.github.koha11.pizza_store_pos.entity.timesheet.Timesheet;
import io.github.koha11.pizza_store_pos.entity.timesheet.TimesheetDTO;
import io.github.koha11.pizza_store_pos.entity.timesheet.TimesheetDetail;
import io.github.koha11.pizza_store_pos.repository.TimesheetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TimesheetService extends GenericService<Timesheet>{
    @Autowired
    private TimesheetRepository timesheetRepo;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private WorkShiftService workShiftService;

    @Autowired
    protected TimesheetMapper mapper;

    public TimesheetService(JpaRepository<Timesheet, String> repo) {
        super(repo);
    }

    // GET METHODS
    public Timesheet getOne(String empId, LocalDate date) {
        Optional<Timesheet> tsOpt = timesheetRepo.findById(empId, date);

        if(tsOpt.isPresent())
            return tsOpt.get();
        else
            throw new IllegalStateException(notFoundIdMsg);
    }

    public List<Timesheet> getTimesheetByDate(LocalDate date) {
        return timesheetRepo.findAllByDate(date);
    }

//    public List<Timesheet> getTimesheetByMonth(Month month, int year) {
//        LocalDate startDate = LocalDate.of(year,month, 1);
//        LocalDate endDate = LocalDate.of(year,month, YearMonth.of(year, month).lengthOfMonth());
//
//        return timesheetRepo.findAllByMonth(startDate, endDate);
//    }

    public List<TimesheetDTO> getTimesheetByMonth(Month month, int year) {
        LocalDate startDate = LocalDate.of(year,month, 1);
        LocalDate endDate = LocalDate.of(year,month, YearMonth.of(year, month).lengthOfMonth());

        List<Timesheet> listOfTS = timesheetRepo.findAllByMonth(startDate, endDate);

        return listOfTS.stream().map(timesheet -> mapper.timesheetToDTO(timesheet)).toList();
    }

    public List<Timesheet> getTimesheetOfEmp(String empId, LocalDate startDate, LocalDate endDate) {
        return timesheetRepo.findByEmpId(empId, startDate, endDate);
    }

    // POST METHODS

    public void create(String empId, LocalDate workingDate, String wsId) {
//        int workingHours = workShiftService.getWSWorkingTime(wsId);
        int workingHours = 0;

        Timesheet ts = new Timesheet(empId, workingDate,wsId, workingHours, 0, Timestamp.valueOf(LocalDateTime.now()));

        timesheetRepo.save(ts);
    }

    public void addSheetForMonth(Month month, int year) {
        if(isExistMonthTimesheet(month, year))
            throw new IllegalStateException("There is available timesheet for this month");

        List<Employee> empList = employeeService.getAll();

        int lastDayOfMonth = YearMonth.of(year, month).lengthOfMonth();

        for (int i = 1; i <= lastDayOfMonth; i++) {
            LocalDate date = LocalDate.of(year, month, i);

            empList.forEach(emp -> {
                if(!emp.getEmpType().getEmpTypeId().equals("ADMIN"))
                    create(emp.getEmpId(),date,emp.getHardWorkShiftId());
            });
        }
    }

    // PUT/PATCH METHODS
    public void setWorkShift(LocalDate date, String empId, String workShiftId){
        Timesheet timesheet = getOne(empId, date);
        int workingHours = workShiftService.getWSWorkingTime(workShiftId);

        timesheet.setWorkShiftId(workShiftId);
        timesheet.setWorkingHours(workingHours);

        timesheetRepo.save(timesheet);
    }

    // Vang lam`
    public void markAbsent(LocalDate date, String empId) {
        Timesheet timesheet = getOne(empId, date);

        timesheet.setWorkingHours(0);

        timesheetRepo.save(timesheet);
    }

    public void adjustOTWorkingHours(LocalDate date, String empId, int ot) {
        Timesheet timesheet = getOne(empId, date);

        timesheet.setOvertimeWorkingHours(ot);

        timesheetRepo.save(timesheet);
    }


    // HELPER METHODS
    public boolean isExistMonthTimesheet(Month month, int year) {
        LocalDate date = LocalDate.of(year, month, 1);

        List<Timesheet> ts = getTimesheetByDate(date);

        return !ts.isEmpty();
    }
}
