package io.github.koha11.pizza_store_pos.repository;

import io.github.koha11.pizza_store_pos.entity.table_reservation.TableReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Optional;

public interface TableReservationRepository extends JpaRepository<TableReservation, String> {
    @Query("select tr from TableReservation tr where tr.orderId = :orderId")
    Optional<TableReservation> findByOrderId(String orderId);

    @Query("select tr from TableReservation tr where tr.tableId = :tableId and date_trunc('day', tr.bookedTime) = current_date and tr.status = 0 order by tr.bookedTime desc limit 1")
    Optional<TableReservation> findByTableId(String tableId);
}
