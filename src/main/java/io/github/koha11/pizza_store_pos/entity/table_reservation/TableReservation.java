package io.github.koha11.pizza_store_pos.entity.table_reservation;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "table_reservations")
@Entity
public class TableReservation {
    @Id
    private String tableReservationId;
    private String tableId;
    private String orderId;
    private String customerFullName;
    private String customerPhone;
    private String note;
    private int dinerCount;
    private ReservationStatus status;
    private LocalDateTime bookedTime;
    private Timestamp createdAt;
}
