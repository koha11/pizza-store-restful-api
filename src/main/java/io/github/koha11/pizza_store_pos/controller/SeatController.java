package io.github.koha11.pizza_store_pos.controller;

import io.github.koha11.pizza_store_pos.entity.seat.Seat;
import io.github.koha11.pizza_store_pos.entity.seat.SeatStatus;
import io.github.koha11.pizza_store_pos.service.GenericService;
import io.github.koha11.pizza_store_pos.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/seats")
public class SeatController extends GenericController<Seat>{
    @Autowired
    private SeatService seatService;

    public SeatController(GenericService<Seat> genericService) {
        super(genericService);
    }

    @GetMapping("/filter")
    public List<Seat> getAll(@RequestParam(name = "stt", required = false
    ) List<SeatStatus> statusList) {
        return seatService.getAll(statusList);
    }

    @GetMapping("/reservable-seats")
    public List<Seat> getReservableSeat(@RequestParam(name = "rd"
    ) LocalDateTime reservedDate, @RequestParam(name="dc") int dinerCount) {
        return seatService.getReservableSeat(reservedDate, dinerCount);
    }
}
