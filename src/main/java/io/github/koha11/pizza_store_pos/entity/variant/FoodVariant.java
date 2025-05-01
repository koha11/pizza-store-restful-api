package io.github.koha11.pizza_store_pos.entity.variant;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "food_variants")
@Entity
@IdClass(FoodVariantId.class)
public class FoodVariant {
    @Id
    private String foodTypeId;

    @Id
    private String variantId;

    private Timestamp createdAt;
}
