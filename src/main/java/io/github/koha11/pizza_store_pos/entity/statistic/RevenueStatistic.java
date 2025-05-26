package io.github.koha11.pizza_store_pos.entity.statistic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RevenueStatistic {
    private String day;
    private int total;
}
