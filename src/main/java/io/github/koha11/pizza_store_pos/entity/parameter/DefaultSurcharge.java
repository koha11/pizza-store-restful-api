package io.github.koha11.pizza_store_pos.entity.parameter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DefaultSurcharge {
    private int value;
    private boolean isActive;
}
