package io.github.koha11.pizza_store_pos.service;

import io.github.koha11.pizza_store_pos.entity.seat.Seat;
import io.github.koha11.pizza_store_pos.entity.seat.SeatStatus;
import io.github.koha11.pizza_store_pos.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class SeatService extends GenericService<Seat>{
    @Autowired
    private SeatRepository seatRepo;

    public SeatService(JpaRepository<Seat, String> repo) {
        super(repo);
    }

    // GET METHODS

    public List<String> getCurrentSeatIds() {
        List<Seat> seats = getAll();

        List<String> seatIds = new ArrayList<>();

        seats.forEach(seat -> {
            if (seat.getSeatStatus() == SeatStatus.UNAVAILABLE)
                 seatIds.add(seat.getSeatId());
        });

        return seatIds;
    }

    public List<Seat> getAll(SeatStatus status) {
        return seatRepo.findAllByStatus(status);
    }

    // POST METHODS

    @Override
    public void create(Seat seat) {
        seat.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
        super.create(seat);
    }

    // PUT/PATCH METHODS

    public void toggleStatus(String seatId) {
        Seat seat = getOne(seatId);

        if(seat.getSeatStatus() == SeatStatus.AVAILABLE)
            seat.setSeatStatus(SeatStatus.OCCUPIED);
        else if(seat.getSeatStatus() == SeatStatus.OCCUPIED)
            seat.setSeatStatus(SeatStatus.AVAILABLE);

        repo.save(seat);
    }

    public void toggleUnavailable(String seatId) {
        Seat seat = getOne(seatId);

        if(seat.getSeatStatus() == SeatStatus.UNAVAILABLE)
            seat.setSeatStatus(SeatStatus.AVAILABLE);
        else
            seat.setSeatStatus(SeatStatus.UNAVAILABLE);

        repo.save(seat);
    }

    // HELPER METHODS

    public boolean isAvailable(String seatId) {
        var seat = getOne(seatId);

        return seat.getSeatStatus() == SeatStatus.AVAILABLE;
    }
}


