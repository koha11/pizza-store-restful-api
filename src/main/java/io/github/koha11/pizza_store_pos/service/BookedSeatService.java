package io.github.koha11.pizza_store_pos.service;

import io.github.koha11.pizza_store_pos.entity.order.BookedSeat;
import io.github.koha11.pizza_store_pos.repository.BookedSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookedSeatService {
    @Autowired
    private BookedSeatRepository bookedSeatRepo;

    public List<BookedSeat> getAll() {
        return bookedSeatRepo.findAll();
    }
}
