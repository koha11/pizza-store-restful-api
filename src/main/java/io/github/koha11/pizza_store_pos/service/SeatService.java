package io.github.koha11.pizza_store_pos.service;

import io.github.koha11.pizza_store_pos.entity.order.BookedSeat;
import io.github.koha11.pizza_store_pos.entity.seat.Seat;
import io.github.koha11.pizza_store_pos.entity.seat.SeatStatus;
import io.github.koha11.pizza_store_pos.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class SeatService extends GenericService<Seat>{
    @Autowired
    private SeatRepository seatRepo;

    @Autowired
    private BookedSeatService bookedSeatService;

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

    public List<Seat> getAll(List<SeatStatus> statusList) {
        List<Seat> seats = getAll();

        return seats.stream().filter(seat -> statusList.contains(seat.getSeatStatus())).toList();
    }

    public List<Seat> getReservableSeat(LocalDateTime reservedDate, int slots) {
        // Lay tat ca ban nhung loai bo di nhung ban` dang bao tri
        List<Seat> seats = getAll(List.of(SeatStatus.AVAILABLE,SeatStatus.RESERVED,SeatStatus.OCCUPIED));

        List<BookedSeat> bookedSeats = bookedSeatService.getBookedSeatsByDateAndSeat(reservedDate, "");

        // Lay ra nhung phieu dat ban co thoi gian chenh lech it hon 3 tieng so voi thoi gian dinh tao phieu va co seatId khac ""
        List<String> sameSeatList = bookedSeats.stream().filter(bookedSeat -> Duration.between(bookedSeat.getBookedTime(), reservedDate).getSeconds() <= 3600*3 && !bookedSeat.getSeatId().isEmpty()).map(BookedSeat::getSeatId).toList();

        // Loc de lay ra so ban khong bi trung lich dat, co so luong cho ngoi thoa man voi so luong khach du kien
        return seats.stream().filter(seat -> !sameSeatList.contains(seat.getSeatId()) && seat.getNumberOfSeat() >= slots).toList();
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


