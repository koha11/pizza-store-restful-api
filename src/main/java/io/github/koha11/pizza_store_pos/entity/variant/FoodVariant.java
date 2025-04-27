package io.github.koha11.pizza_store_pos.entity.variant;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "foodvariants")
@Entity
@IdClass(FoodVariantId.class)
public class FoodVariant {
    @Id
    private String foodTypeId;

    @Id
    private String variantId;
}
