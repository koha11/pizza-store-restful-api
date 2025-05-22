package io.github.koha11.pizza_store_pos.repository;

import io.github.koha11.pizza_store_pos.entity.order.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {

    @Query("SELECT od FROM OrderDetail od WHERE od.orderId = :orderId ORDER BY od.createdAt")
    List<OrderDetail> findByOrderId(String orderId);

    @Query("SELECT od FROM OrderDetail od WHERE od.orderId = :orderId and od.foodId = :foodId ORDER BY od.createdAt")
    Optional<OrderDetail> findByIds(String orderId, String foodId);
}
