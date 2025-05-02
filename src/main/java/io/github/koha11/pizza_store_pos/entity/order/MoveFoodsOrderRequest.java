package io.github.koha11.pizza_store_pos.entity.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MoveFoodsOrderRequest {
    private String changedSeatId;
    private String serverId;
    private List<OnTableOrderDetail> foods;
}
