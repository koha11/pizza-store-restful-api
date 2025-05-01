package io.github.koha11.pizza_store_pos.controller;

import io.github.koha11.pizza_store_pos.entity.order.CreateOrderRequest;
import io.github.koha11.pizza_store_pos.entity.order.OnTableOrder;
import io.github.koha11.pizza_store_pos.entity.order.Order;
import io.github.koha11.pizza_store_pos.service.GenericService;
import io.github.koha11.pizza_store_pos.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController extends GenericController<Order>{
    @Autowired
    private OrderService orderService;

    public OrderController(GenericService<Order> genericService) {
        super(genericService);
    }

    @GetMapping("/get-order/{seatId}")
    public OnTableOrder getBySeatId(@PathVariable String seatId) {
        return orderService.getCurrentSeatOrder(seatId);
    }

    @GetMapping("/get-orders-by-date")
    public List<OnTableOrder> getByDate(@RequestParam String dateString) {
        try {
            LocalDate date = LocalDate.parse(dateString);
            return orderService.getOrdersByDate(date);
        }
        catch (Exception e) {
            throw new IllegalStateException(e.getMessage());
        }
    }

    @PostMapping
    public void create(@RequestBody CreateOrderRequest t) {
        orderService.create(t.getSeatId(),t.getServerId(), t.getFoods());
    }
}
