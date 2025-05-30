package io.github.koha11.pizza_store_pos.repository;

import io.github.koha11.pizza_store_pos.entity.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, String> {
    @Query("SELECT o from Order o where o.tableId = :tableId and o.status = 0 ORDER BY o.createdAt")
    Optional<Order> findByTableId(String tableId);

    @Query("SELECT o from Order o where o.orderId like %:dateString% ORDER BY o.createdAt  ")
    List<Order> findAllByDateString(@Param("dateString") String dateString);

    @Query("SELECT o from Order o where o.timeIn >= :dateStart and o.timeIn <= :dateEnd  ORDER BY o.createdAt  ")
    List<Order> findAllByDate(LocalDateTime dateStart, LocalDateTime dateEnd);
}
