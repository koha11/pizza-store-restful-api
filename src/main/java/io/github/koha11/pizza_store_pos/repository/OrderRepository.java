package io.github.koha11.pizza_store_pos.repository;

import io.github.koha11.pizza_store_pos.entity.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, String> {
    @Query("SELECT o from Order o where o.seatId = :seatId and o.status = 0 ORDER BY o.createdAt")
    Optional<Order> findBySeatId(String seatId);

    @Query("SELECT o from Order o where o.orderId like '%dateString%' ORDER BY o.createdAt  ")
    List<Order> findAllByDateString(@Param("dateString") String dateString);

    @Query("SELECT o from Order o where o.status = 1 ORDER BY o.createdAt")
    List<Order> findAllByStatus();
}
