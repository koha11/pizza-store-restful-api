package io.github.koha11.pizza_store_pos.service;

import io.github.koha11.pizza_store_pos.entity.employee.Employee;
import io.github.koha11.pizza_store_pos.entity.mapper.TimesheetMapper;
import io.github.koha11.pizza_store_pos.entity.timesheet.*;
import io.github.koha11.pizza_store_pos.repository.TimesheetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class TimesheetService extends GenericService<Timesheet>{
    @Autowired
    private TimesheetRepository timesheetRepo;

    @Autowired
    private EmployeeService employeeService;


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

        return listOfTS.stream().sorted(Comparator.comparing(Timesheet::getWorkingDate)).map(timesheet -> mapper.timesheetToDTO(timesheet)).toList();
    }

    public List<Timesheet> getTimesheetOfEmp(String empId, LocalDate startDate, LocalDate endDate) {
        return timesheetRepo.findByEmpId(empId, startDate, endDate);
    }

    // POST METHODS
    public void attendance(AttendanceRequest request) {
        Timesheet timesheet = getOne(request.getEmpId(), request.getWorkingDate());
        timesheet.setWorkingHours(8);
        if(request.getOtHours() > 0) {
            timesheet.setOvertimeWorkingHours(request.getOtHours());
        }
        timesheet.setStatus(true);
        timesheetRepo.save(timesheet);
    }

    public void create(String empId, LocalDate workingDate, WorkShift ws) {
//        int workingHours = workShiftService.getWSWorkingTime(wsId);
        int workingHours = 0;

        Timesheet ts = new Timesheet(empId,  workingDate, false,ws.getWorkShiftId(), workingHours, 0, Timestamp.valueOf(LocalDateTime.now()));

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
                    create(emp.getEmpId(),date,emp.getWorkShift());
            });
        }
    }

    // PUT/PATCH METHODS
    public void setWorkShift(ShiftRegistrationRequest request){
        Timesheet timesheet = getOne(request.getEmpId(), request.getWorkingDate());
        timesheet.setWorkShiftId(request.getWorkShiftId());
        timesheetRepo.save(timesheet);
    }

    // Vang lam`
    public void markAbsent(AttendanceRequest request) {
        Timesheet timesheet = getOne(request.getEmpId(), request.getWorkingDate());
        timesheet.setStatus(true);
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
