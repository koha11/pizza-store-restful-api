package io.github.koha11.pizza_store_pos.entity.order;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
@Entity
public class Order {
    @Id
    private String orderId;
    private String seatId;
    private String serverId;
    private String cashierId;
    private LocalDateTime timeIn;
    private LocalDateTime timeOut;
    private OrderStatus status;
    private String note;
    private float discount;
    private int surcharge;
    private PaymentMethod paymentMethod;
    private int total;
    private Timestamp createdAt;
}
