package io.github.koha11.pizza_store_pos.entity.order;

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
@Table(name = "booked_seat")
@Entity
public class BookedSeat {
    @Id
    private String bookedSeatId;
    private String seatId;
    private String orderId;
    private String customerFullName;
    private String customerPhone;
    private int slots;
    private LocalDateTime bookedTime;
    private Timestamp createdAt;
}
