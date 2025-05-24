package io.github.koha11.pizza_store_pos.controller;

import io.github.koha11.pizza_store_pos.entity.order.*;
import io.github.koha11.pizza_store_pos.service.GenericService;
import io.github.koha11.pizza_store_pos.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
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
    @GetMapping("/period")
    public List<OrderStatistic> getOrdersByMonthAndYear(@RequestParam Month month, @RequestParam int year, @RequestParam boolean isCurrent) {
        return orderService.getOrdersByMonthAndYear(month, year, isCurrent);
    }

    @GetMapping("/get-by-seat-id/{seatId}")
    public OnTableOrder getBySeatId(@PathVariable String seatId) {
        return orderService.getCurrentSeatOrder(seatId);
    }

    @GetMapping("/get-by-order-id/{orderId}")
    public OrderStatistic getByOrderId(@PathVariable String orderId) {
        return orderService.getOrderByOrderId(orderId);
    }

    @PostMapping
    public OnTableOrder create(@RequestBody CreateOrderRequest t) {
        return orderService.create(t.getSeatId(),t.getServerId(), t.getNote(),t.getFoods());
    }

    @PostMapping("/add-food/{seatId}")
    public OnTableOrderDetail addFood(@PathVariable String seatId, @RequestBody OnTableOrderDetail od) {
        return orderService.addFoodOrder(seatId,od);
    }

    @PutMapping("/edit-on-table-order")
    public OnTableOrder editOnTableOrder(@RequestBody OnTableOrder order) {
        return orderService.editOnTableOrder(order);
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
