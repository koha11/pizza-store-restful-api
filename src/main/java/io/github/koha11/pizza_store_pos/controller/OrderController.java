package io.github.koha11.pizza_store_pos.controller;

import io.github.koha11.pizza_store_pos.entity.order.CreateOrderRequest;
import io.github.koha11.pizza_store_pos.entity.order.OnTableOrder;
import io.github.koha11.pizza_store_pos.entity.order.Order;
import io.github.koha11.pizza_store_pos.service.GenericService;
import io.github.koha11.pizza_store_pos.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public void create(@RequestBody CreateOrderRequest t) {
        orderService.create(t.getSeatId(),t.getServerId());
    }
}
