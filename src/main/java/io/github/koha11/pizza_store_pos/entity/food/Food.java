package io.github.koha11.pizza_store_pos.entity.food;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "foods")
@Entity
public class Food {
    @Id
    private String foodId;// foreign key
    private String foodTypeId;
    private String foodName;
    private String foodImage;
    private String description;
    private int price;
    private Timestamp createdAt;
}
