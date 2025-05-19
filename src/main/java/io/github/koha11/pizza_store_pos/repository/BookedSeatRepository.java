package io.github.koha11.pizza_store_pos.repository;

import io.github.koha11.pizza_store_pos.entity.order.BookedSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BookedSeatRepository extends JpaRepository<BookedSeat, String> {
    @Query("select bs from BookedSeat bs where bs.orderId = :orderId")
    Optional<BookedSeat> findByOrderId(String orderId);
}
