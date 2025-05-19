package io.github.koha11.pizza_store_pos.controller;

import io.github.koha11.pizza_store_pos.entity.order.BookedSeat;
import io.github.koha11.pizza_store_pos.service.BookedSeatService;
import io.github.koha11.pizza_store_pos.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booked-seats")
public class BookedSeatController extends GenericController<BookedSeat>{
    @Autowired
    private BookedSeatService bookedSeatService;

    public BookedSeatController(GenericService<BookedSeat> genericService) {
        super(genericService);
    }

    // GET METHODS
    @GetMapping("/get-by-order-id/{orderId}")
    public BookedSeat getByOrderId(@PathVariable String orderId) {
        return bookedSeatService.getBookedSeatByOrderId(orderId);
    }

    // POST METHODS
    @PostMapping
    public void create(@RequestBody BookedSeat t) {
        bookedSeatService.create(t);
    }

}
