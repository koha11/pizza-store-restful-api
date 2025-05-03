package io.github.koha11.pizza_store_pos.service;

import io.github.koha11.pizza_store_pos.entity.food.FoodType;
import io.github.koha11.pizza_store_pos.entity.order.BookedSeat;
import io.github.koha11.pizza_store_pos.repository.BookedSeatRepository;
import io.github.koha11.pizza_store_pos.util.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookedSeatService extends GenericService<BookedSeat>{
    @Autowired
    private BookedSeatRepository bookedSeatRepo;

    public BookedSeatService(JpaRepository<BookedSeat, String> repo) {
        super(repo);
    }

    public List<BookedSeat> getBookedSeatByDateAndSeat(Timestamp bookedTime, String seatId) {

        return null;
    }

    @Override
    public void create(BookedSeat t) {
        var listOfT = this.getAll();
        var id = Helper.generateId(BookedSeat.class, listOfT.size());
        t.setBookedSeatId(id);
        t.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
        repo.save(t);
    }
}
