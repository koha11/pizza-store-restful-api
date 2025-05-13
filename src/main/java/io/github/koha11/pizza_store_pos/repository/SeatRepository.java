package io.github.koha11.pizza_store_pos.repository;

import io.github.koha11.pizza_store_pos.entity.seat.Seat;
import io.github.koha11.pizza_store_pos.entity.seat.SeatStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, String> {
    @Query("Select s from Seat s where s.seatStatus = :status")
    List<Seat> findAllByStatus(SeatStatus status);
}
