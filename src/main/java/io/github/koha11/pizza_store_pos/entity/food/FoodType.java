package io.github.koha11.pizza_store_pos.entity.food;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "food_types")
@Entity
public class FoodType {
    @Id
    private String foodTypeId;
    private String foodTypeName;
    private String foodTypeImage;
    @OneToMany
            (mappedBy = "foodTypeId", cascade = CascadeType.ALL, orphanRemoval = true, targetEntity = Food.class)
    private List<Food> foods;
    private Timestamp createdAt = Timestamp.valueOf(LocalDateTime.now());

    public FoodType(String foodTypeId, String foodTypeName, String foodTypeImage, Timestamp createdAt) {
        this.foodTypeId = foodTypeId;
        this.foodTypeName = foodTypeName;
        this.foodTypeImage = foodTypeImage;
        this.createdAt = createdAt;
    }
}
