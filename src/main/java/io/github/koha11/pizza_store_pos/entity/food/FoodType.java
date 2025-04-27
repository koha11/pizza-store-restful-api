package io.github.koha11.pizza_store_pos.entity.food;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "foodtypes")
@Entity
public class FoodType {
    @Id
    private String foodTypeId;
    private String foodTypeName;
}
