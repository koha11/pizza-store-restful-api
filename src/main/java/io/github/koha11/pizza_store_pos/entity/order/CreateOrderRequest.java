package io.github.koha11.pizza_store_pos.entity.order;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderRequest {
    private String seatId;
    private String serverId;
    private String note;
    private List<OnTableOrderDetail> foods;
}
