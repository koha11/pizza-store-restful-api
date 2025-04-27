package io.github.koha11.pizza_store_pos.repository;

import io.github.koha11.pizza_store_pos.entity.timesheet.Timesheet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimesheetRepository extends JpaRepository<Timesheet, String> {
}
