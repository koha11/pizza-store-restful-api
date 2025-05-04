package io.github.koha11.pizza_store_pos.repository;

import io.github.koha11.pizza_store_pos.entity.violation.Violation;
import io.github.koha11.pizza_store_pos.entity.violation.ViolationRecord;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ViolationRecordRepository extends JpaRepository<ViolationRecord, String> {
    @Query("select vr from ViolationRecord vr where vr.workingDate = :date")
    List<ViolationRecord> findAllByDate(LocalDate date);

    @Query("select vr from ViolationRecord vr where vr.empId = :empId and vr.workingDate >= :startDate and vr.workingDate <= :endDate ")
    List<ViolationRecord> findAllByEmpId(String empId, LocalDate startDate, LocalDate endDate);
}
