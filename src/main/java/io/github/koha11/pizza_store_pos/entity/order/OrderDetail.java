package io.github.koha11.pizza_store_pos.entity.order;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private int amount;
    private int actualPrice;
}
