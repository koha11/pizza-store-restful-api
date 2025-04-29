package io.github.koha11.pizza_store_pos.entity.food;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "foods")
@Entity
public class Food {
    @Id
    private String foodId;
    private String foodTypeId;
    private String foodName;
    private String foodImage;
    private String description;
    private int price;
}
