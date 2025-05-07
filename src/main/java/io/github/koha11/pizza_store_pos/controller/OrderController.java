package io.github.koha11.pizza_store_pos.controller;

import io.github.koha11.pizza_store_pos.entity.order.*;
import io.github.koha11.pizza_store_pos.service.GenericService;
import io.github.koha11.pizza_store_pos.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
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

    @GetMapping("/get-orders")
    public List<OrderStatistic> getOrders(@RequestParam(required = false, name = "stt") OrderStatus status, @RequestParam(required = false, name = "ds") LocalDate dateStart, @RequestParam(required = false, name = "de") LocalDate dateEnd) {

        return orderService.getOrders(status, dateStart, dateEnd);
    }

    @GetMapping("/get-by-seat-id/{seatId}")
    public OnTableOrder getBySeatId(@PathVariable String seatId) {
        return orderService.getCurrentSeatOrder(seatId);
    }


    @PostMapping
    public void create(@RequestBody CreateOrderRequest t) {
        orderService.create(t.getSeatId(),t.getServerId(),t.getFoods());
    }

    @PostMapping("/add-food/{seatId}")
    public void addFood(@PathVariable String seatId, @RequestBody OnTableOrderDetail od) {
        orderService.addFoodOrder(seatId,od);
    }

    @PutMapping("/edit-food-order/{seatId}")
    public void editFoodOrder(@PathVariable String seatId, @RequestBody OnTableOrderDetail od) {
        orderService.editFoodOrder(seatId, od);
    }

    @PutMapping("/adjust-amount/{seatId}")
    public void adjustAmount(@PathVariable String seatId, @RequestParam boolean isIncrease, @RequestParam String foodId) {
        orderService.adjustAmount(isIncrease,seatId,foodId);
    }

    @PutMapping("/pay-order/{seatId}")
    public void payOrder(@PathVariable String seatId, @RequestBody OrderPayment op) {
        orderService.payOrder(seatId,op.getCashierId(), op.getPaymentMethod(), op.getDiscount(), op.getSurcharge());
    }

    @PutMapping("/change-seat/{seatId}")
    public void changeSeat(@PathVariable String seatId, @RequestParam String changedSeatId) {
        orderService.changeSeat(seatId,changedSeatId);
    }

    @PutMapping("/move-foods/{seatId}")
    public void moveFoodsToDiffSeat(@PathVariable String seatId, @RequestBody MoveFoodsOrderRequest request) {
        orderService.moveFoodsToDiffSeat(seatId, request.getFoods(), request.getChangedSeatId(), request.getServerId());
    }

    @DeleteMapping("/remove-food-order/{seatId}")
    public void removeFoodOrder(@PathVariable String seatId, @RequestParam String foodId) {
        orderService.removeFoodOrder(seatId, foodId);
    }
}
