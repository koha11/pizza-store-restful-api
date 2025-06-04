package io.github.koha11.pizza_store_pos.entity.parameter;

import io.github.koha11.pizza_store_pos.entity.order.OrderStatus;
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
@Table(name = "config_parameters")
@Entity
public class ConfigParameter {
    @Id
    private String paramId;
    private String paramName;
    private String paramType;
    private String paramValue;
    private Boolean isParamActive;
    private Timestamp createdAt;
}
