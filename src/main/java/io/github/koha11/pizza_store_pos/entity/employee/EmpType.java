package io.github.koha11.pizza_store_pos.entity.employee;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "emptypes")
@Entity
public class EmpType {
    @Id
    private String empTypeId;
    private String empTypeName;
    private int basicSalary;
}
