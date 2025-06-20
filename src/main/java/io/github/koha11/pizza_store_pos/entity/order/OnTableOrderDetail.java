package io.github.koha11.pizza_store_pos.entity.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OnTableOrderDetail {
    private String orderId;
    private String foodId;
    private String foodName;
    private String foodTypeName;
    private String foodImage;
    private int price;
    private String note;
    private int amount;
    private int actualPrice;
}
