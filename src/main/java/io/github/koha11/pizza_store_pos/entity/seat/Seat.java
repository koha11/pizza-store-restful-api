package io.github.koha11.pizza_store_pos.entity.seat;

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
@Table(name = "seats")
@Entity
public class Seat {
    @Id
    private String seatId;
    private SeatStatus seatStatus;
    private int numberOfSeat;
    private Timestamp createdAt;
}
