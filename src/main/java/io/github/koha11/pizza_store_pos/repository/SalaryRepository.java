package io.github.koha11.pizza_store_pos.repository;

import io.github.koha11.pizza_store_pos.entity.salary.Salary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.Month;
import java.util.List;

public interface SalaryRepository extends JpaRepository<Salary, String> {
    @Query("select sl from Salary sl where sl.month = :month and sl.year = :year")
    List<Salary> findAllByMonthYear(@Param("month") Month month, @Param("year") int year);
}
