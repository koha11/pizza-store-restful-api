package io.github.koha11.pizza_store_pos.entity.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderStatistic {
    private String orderId;
    private String tableId;
    private OrderStatus status;
    private String note;
    private String serverName;
    private String cashierName;
    private LocalDateTime timeIn;
    private LocalDateTime timeOut;
    private List<OnTableOrderDetail> foods;
    private float discount;
    private int surcharge;
    private PaymentMethod paymentMethod;
    private int total;
}
