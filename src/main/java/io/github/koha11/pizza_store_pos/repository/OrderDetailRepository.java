package io.github.koha11.pizza_store_pos.repository;

import io.github.koha11.pizza_store_pos.entity.order.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {
    @Query("SELECT od FROM OrderDetail od WHERE od.orderId = :orderId")
    List<OrderDetail> findByOrderId(@Param("orderId") String orderId);
}
