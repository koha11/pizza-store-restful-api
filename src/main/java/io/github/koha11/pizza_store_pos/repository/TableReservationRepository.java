package io.github.koha11.pizza_store_pos.repository;

import io.github.koha11.pizza_store_pos.entity.table_reservation.TableReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TableReservationRepository extends JpaRepository<TableReservation, String> {
    @Query("select bs from TableReservation bs where bs.orderId = :orderId")
    Optional<TableReservation> findByOrderId(String orderId);
}
