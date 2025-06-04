package io.github.koha11.pizza_store_pos.entity.order;

import io.github.koha11.pizza_store_pos.entity.food.Food;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order_details")
@Entity
@IdClass(OrderId.class)
public class OrderDetail {
    @Id
    private String orderId;
    @Id
    private String foodId;
    private String note;
    private int amount;
    private int actualPrice;
    private Timestamp createdAt;
}
