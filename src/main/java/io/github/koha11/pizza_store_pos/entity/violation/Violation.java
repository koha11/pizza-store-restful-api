package io.github.koha11.pizza_store_pos.entity.violation;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "violation")
@Entity
public class Violation {
    @Id
    private String violationId;
    private String violationContent;
    private int violationFine;
}
