package io.github.koha11.pizza_store_pos.controller;

import io.github.koha11.pizza_store_pos.entity.order.BookedSeat;
import io.github.koha11.pizza_store_pos.service.BookedSeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/booked-seats")
public class BookedSeatController {
    @Autowired
    private BookedSeatService bookedSeatService;

    @GetMapping
    public List<BookedSeat> getAll() {
        return bookedSeatService.getAll();
    }
}
