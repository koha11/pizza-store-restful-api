package io.github.koha11.pizza_store_pos.entity.statistic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodTypeStatistic {
    private String foodType;
    private int total;
}
