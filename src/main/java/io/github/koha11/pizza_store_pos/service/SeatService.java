package io.github.koha11.pizza_store_pos.service;

import io.github.koha11.pizza_store_pos.entity.seat.Seat;
import io.github.koha11.pizza_store_pos.entity.seat.SeatStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SeatService extends GenericService<Seat>{
    public SeatService(JpaRepository<Seat, String> repo) {
        super(repo);
    }

    // GET METHODS

    public boolean isAvailable(String seatId) {
        var seat = getOne(seatId);

        return seat.getSeatStatus() == SeatStatus.AVAILABLE;
    }

    public List<String> getCurrentSeatIds() {
        List<Seat> seats = getAll();

        List<String> seatIds = new ArrayList<>();

        seats.forEach(seat -> {
            if (seat.getSeatStatus() == SeatStatus.UNAVAILABLE)
                 seatIds.add(seat.getSeatId());
        });

        return seatIds;
    }

    // PUT/PATCH METHODS

    public void toggleStatus(String seatId) {
        Seat seat = getOne(seatId);

        if(seat.getSeatStatus() == SeatStatus.AVAILABLE)
            seat.setSeatStatus(SeatStatus.UNAVAILABLE);
        else if(seat.getSeatStatus() == SeatStatus.UNAVAILABLE)
            seat.setSeatStatus(SeatStatus.AVAILABLE);

        repo.save(seat);
    }

    public void toggleMaintain(String seatId) {
        Seat seat = getOne(seatId);

        if(seat.getSeatStatus() == SeatStatus.MAINTAIN)
            seat.setSeatStatus(SeatStatus.AVAILABLE);
        else
            seat.setSeatStatus(SeatStatus.MAINTAIN);

        repo.save(seat);
    }
}


