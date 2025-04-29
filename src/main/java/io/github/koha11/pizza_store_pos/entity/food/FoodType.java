package io.github.koha11.pizza_store_pos.entity.food;

import io.github.koha11.pizza_store_pos.entity.variant.Variant;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "food_types")
@Entity
public class FoodType {
    @Id
    private String foodTypeId;
    private String foodTypeName;
    private String foodTypeImage;
}
