package io.github.koha11.pizza_store_pos.repository;

import io.github.koha11.pizza_store_pos.entity.seat.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat, String> {
}
