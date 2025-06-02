package io.github.koha11.pizza_store_pos.entity.food;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodDTO {
    private String foodId;
    private FoodType foodType;
    private String foodName;
    private String foodImage;
    private String description;
    private int price;
    private Timestamp createdAt;
}
