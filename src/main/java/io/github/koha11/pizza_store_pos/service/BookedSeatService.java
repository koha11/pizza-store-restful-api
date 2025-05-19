package io.github.koha11.pizza_store_pos.service;

import io.github.koha11.pizza_store_pos.entity.food.FoodType;
import io.github.koha11.pizza_store_pos.entity.order.BookedSeat;
import io.github.koha11.pizza_store_pos.repository.BookedSeatRepository;
import io.github.koha11.pizza_store_pos.util.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BookedSeatService extends GenericService<BookedSeat>{
    @Autowired
    private BookedSeatRepository bookedSeatRepo;

    public BookedSeatService(JpaRepository<BookedSeat, String> repo) {
        super(repo);
    }

    // GET METHODS
    public List<BookedSeat> getBookedSeatsByDateAndSeat(LocalDateTime bookedTime, String seatId) {
        List<BookedSeat> bookedSeats = getAll();

        return bookedSeats.stream().filter(bookedSeat -> {
            if(seatId.isEmpty())
                return bookedSeat.getBookedTime().getDayOfMonth() == bookedTime.getDayOfMonth();
            else
                return bookedSeat.getBookedTime().getDayOfMonth() == bookedTime.getDayOfMonth() && bookedSeat.getSeatId().equals(seatId);

        }).toList();
    }

    public BookedSeat getBookedSeatByOrderId(String orderId) {
        Optional<BookedSeat> bsOpt = bookedSeatRepo.findByOrderId(orderId);

        if(bsOpt.isPresent()) {
            return bsOpt.get();
        }
        else throw new IllegalStateException("Order Id not found");
    }

    // POST METHODS
    @Override
    public void create(BookedSeat t) {
        var listOfT = this.getAll();
        var id = Helper.generateId(BookedSeat.class, listOfT.size());
        t.setBookedSeatId(id);
        t.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
        repo.save(t);
    }
}
