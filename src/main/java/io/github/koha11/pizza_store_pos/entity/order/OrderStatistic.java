package io.github.koha11.pizza_store_pos.entity.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderStatistic {
    private String orderId;
    private String seatId;
    private String serverName;
    private String cashierName;
    private Timestamp timeIn;
    private Timestamp timeOut;
    private List<OnTableOrderDetail> foods;
    private float discount;
    private int surcharge;
    private PaymentMethod paymentMethod;
    private int total;
}
