package io.github.koha11.pizza_store_pos.entity.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OnTableOrderDetail {
    private String foodName;
    private String foodImage;
    private String variantName;
    private String note;
    private int amount;
    private int actualPrice;
}
