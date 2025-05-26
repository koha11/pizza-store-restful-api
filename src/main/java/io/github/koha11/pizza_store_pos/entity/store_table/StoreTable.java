package io.github.koha11.pizza_store_pos.entity.store_table;

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
@Table(name = "store_tables")
@Entity
public class StoreTable {
    @Id
    private String tableId;
    private TableStatus tableStatus;
    private int seats;
    private Timestamp createdAt;
}
