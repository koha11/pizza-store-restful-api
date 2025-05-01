package io.github.koha11.pizza_store_pos.entity.variant;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "variants")
@Entity
public class Variant {
    @Id
    private String variantId;
    private String variantName;
    private int extraPrice;
    private Timestamp createdAt;
}
