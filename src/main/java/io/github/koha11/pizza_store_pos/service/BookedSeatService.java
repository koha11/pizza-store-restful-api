package io.github.koha11.pizza_store_pos.service;

import io.github.koha11.pizza_store_pos.entity.order.TableReservation;
import io.github.koha11.pizza_store_pos.repository.BookedSeatRepository;
import io.github.koha11.pizza_store_pos.util.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BookedSeatService extends GenericService<TableReservation>{
    @Autowired
    private BookedSeatRepository bookedSeatRepo;

    public BookedSeatService(JpaRepository<TableReservation, String> repo) {
        super(repo);
    }

    // GET METHODS
    public List<TableReservation> getBookedSeatsByDateAndSeat(LocalDateTime bookedTime, String seatId) {
        List<TableReservation> tableReservations = getAll();

        return tableReservations.stream().filter(bookedSeat -> {
            if(seatId.isEmpty())
                return bookedSeat.getBookedTime().getDayOfMonth() == bookedTime.getDayOfMonth();
            else
                return bookedSeat.getBookedTime().getDayOfMonth() == bookedTime.getDayOfMonth() && bookedSeat.getSeatId().equals(seatId);

        }).toList();
    }

    public TableReservation getBookedSeatByOrderId(String orderId) {
        Optional<TableReservation> bsOpt = bookedSeatRepo.findByOrderId(orderId);

        if(bsOpt.isPresent()) {
            return bsOpt.get();
        }
        else throw new IllegalStateException("Order Id not found");
    }

    // POST METHODS
    @Override
    public void create(TableReservation t) {
        var listOfT = this.getAll();
        var id = Helper.generateId(TableReservation.class, listOfT.size());
        t.setTableReservationId(id);
        t.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
        repo.save(t);
    }
}
