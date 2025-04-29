package io.github.koha11.pizza_store_pos.controller;

import io.github.koha11.pizza_store_pos.entity.seat.Seat;
import io.github.koha11.pizza_store_pos.service.GenericService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seats")
public class SeatController extends GenericController<Seat>{
    public SeatController(GenericService<Seat> genericService) {
        super(genericService);
    }
}
