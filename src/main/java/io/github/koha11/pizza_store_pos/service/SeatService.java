package io.github.koha11.pizza_store_pos.service;

import io.github.koha11.pizza_store_pos.entity.seat.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class SeatService extends GenericService<Seat>{
    public SeatService(JpaRepository<Seat, String> repo) {
        super(repo);
    }
}
