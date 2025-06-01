package io.github.koha11.pizza_store_pos.controller;

import io.github.koha11.pizza_store_pos.entity.table_reservation.TableReservation;
import io.github.koha11.pizza_store_pos.service.TableReservationService;
import io.github.koha11.pizza_store_pos.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/table-reservations")
public class TableReservationController extends GenericController<TableReservation>{
    @Autowired
    private TableReservationService tableReservationService;

    public TableReservationController(GenericService<TableReservation> genericService) {
        super(genericService);
    }

    // GET METHODS
    @GetMapping("/get-by-order-id/{orderId}")
    public TableReservation getByOrderId(@PathVariable String orderId) {
        return tableReservationService.getTableReservationByOrderId(orderId);
    }
//    // GET METHODS
//    @GetMapping("/get-upcoming-reservation")
//    public List<TableReservation> getByOrderId(@PathVariable String orderId) {
//        return tableReservationService.getTableReservationByOrderId(orderId);
//    }

    // POST METHODS
    @PostMapping
    public void create(@RequestBody TableReservation t) {
        tableReservationService.create(t);
    }

}
