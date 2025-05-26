package io.github.koha11.pizza_store_pos.repository;

import io.github.koha11.pizza_store_pos.entity.store_table.StoreTable;
import io.github.koha11.pizza_store_pos.entity.store_table.TableStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TableRepository extends JpaRepository<StoreTable, String> {
    @Query("Select s from StoreTable s where s.tableStatus = :status")
    List<StoreTable> findAllByStatus(TableStatus status);
}
