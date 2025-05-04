package io.github.koha11.pizza_store_pos.repository;

import io.github.koha11.pizza_store_pos.entity.timesheet.Timesheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface TimesheetRepository extends JpaRepository<Timesheet, String> {
    @Query("select ts from Timesheet ts where ts.workingDate = :date")
    List<Timesheet> findAllByDate(@Param("date") LocalDate date);

    @Query("select ts from Timesheet ts where ts.empId = :empId and ts.workingDate = :date")
    Optional<Timesheet> findById(@Param("empId") String empId, @Param("date") LocalDate date);

    @Query("select ts from Timesheet ts where ts.workingDate >= :startDate and ts.workingDate <= :endDate")
    List<Timesheet> findAllByMonth(LocalDate startDate, LocalDate endDate);

    @Query("select ts from Timesheet ts where ts.workingDate >= :startDate and ts.workingDate <= :endDate and ts.empId = :empId")
    List<Timesheet> findByEmpId(String empId, LocalDate startDate, LocalDate endDate);
}
