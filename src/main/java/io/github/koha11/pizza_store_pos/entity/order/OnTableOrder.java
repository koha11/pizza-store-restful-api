package io.github.koha11.pizza_store_pos.entity.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OnTableOrder {
    private String orderId;
    private String tableId;
    private String serverId;
    private LocalDateTime timeIn;
    private List<OnTableOrderDetail> foods;
    private String note;
    private float discount;
    private int surcharge;
    private int total;
}
