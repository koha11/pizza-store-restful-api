package io.github.koha11.pizza_store_pos.controller;

import io.github.koha11.pizza_store_pos.entity.order.*;
import io.github.koha11.pizza_store_pos.entity.statistic.FoodTypeStatistic;
import io.github.koha11.pizza_store_pos.entity.statistic.RevenueStatistic;
import io.github.koha11.pizza_store_pos.service.GenericService;
import io.github.koha11.pizza_store_pos.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
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
    @PreAuthorize("hasAnyRole('ADMIN', 'CASHIER', 'MANAGER')")
    public List<OrderStatistic> getOrders(@RequestParam(required = false, name = "stt") OrderStatus status, @RequestParam(required = false, name = "ds") LocalDate dateStart, @RequestParam(required = false, name = "de") LocalDate dateEnd) {

        return orderService.getOrders(status, dateStart, dateEnd);
    }

    @GetMapping("/today")
    @PreAuthorize("hasAnyRole('ADMIN', 'CASHIER', 'MANAGER')")
    public List<OrderStatistic> getOrdersToday() {
        return orderService.getOrdersToday();
    }

    @GetMapping("/statistic")
    @PreAuthorize("hasAnyRole('ADMIN', 'CASHIER', 'MANAGER')")
    public List<RevenueStatistic> getRevenueStatisticsByMonthAndYear(@RequestParam Month month, @RequestParam int year) {
        return orderService.getRevenueStatisticByMonthAndYear(month, year);
    }

    @GetMapping("/statistic/food-type")
    @PreAuthorize("hasAnyRole('ADMIN', 'CASHIER', 'MANAGER')")
    public List<FoodTypeStatistic> getFoodTypeRevenueStatisticByMonthAndYear(@RequestParam Month month, @RequestParam int year) {
        return orderService.getFoodTypeRevenueStatisticByMonthAndYear(month, year);
    }

    @GetMapping("/get-by-table-id/{tableId}")
    public OnTableOrder getByTableId(@PathVariable String tableId) {
        return orderService.getCurrentTableOrder(tableId);
    }

    @GetMapping("/get-by-order-id/{orderId}")
    public OrderStatistic getByOrderId(@PathVariable String orderId) {
        return orderService.getOrderByOrderId(orderId);
    }

    @PostMapping
    public OnTableOrder create(@RequestBody CreateOrderRequest t) {
        return orderService.create(t.getTableId(),t.getServerId(), t.getNote(),t.getFoods());
    }

    @PostMapping("/add-food/{tableId}")
    public OnTableOrderDetail addFood(@PathVariable String tableId, @RequestBody OnTableOrderDetail od) {
        return orderService.addFoodOrder(tableId,od);
    }

    @PutMapping("/edit-on-table-order")
    public OnTableOrder editOnTableOrder(@RequestBody OnTableOrder order) {
        return orderService.editOnTableOrder(order);
    }

    @PutMapping("/edit-food-order/{tableId}")
    public void editFoodOrder(@PathVariable String tableId, @RequestBody OnTableOrderDetail od) {
        orderService.editFoodOrder(tableId, od);
    }

    @PutMapping("/adjust-amount/{tableId}")
    public void adjustAmount(@PathVariable String tableId, @RequestParam boolean isIncrease, @RequestParam String foodId) {
        orderService.adjustAmount(isIncrease, tableId,foodId);
    }

    @PutMapping("/pay-order/{tableId}")
    @PreAuthorize("hasAnyRole('ADMIN', 'CASHIER')")
    public void payOrder(@PathVariable String tableId, @RequestBody OrderPayment op) {
        orderService.payOrder(tableId,op.getCashierId(), op.getPaymentMethod(), op.getDiscount(), op.getSurcharge());
    }

    @PutMapping("/change-seat/{tableId}")
    public void changeTable(@PathVariable String tableId, @RequestParam String changedTableId) {
        orderService.changeTable(tableId, changedTableId);
    }

    @PutMapping("/move-foods/{tableId}")
    public void moveFoodsToDiffTable(@PathVariable String tableId, @RequestBody MoveFoodsOrderRequest request) {
        orderService.moveFoodsToDiffTable(tableId, request.getFoods(), request.getChangedTableId(), request.getServerId());
    }

    @DeleteMapping("/remove-food-order/{tableId}")
    @PreAuthorize("hasAnyRole('ADMIN', 'CASHIER')")
    public void removeFoodOrder(@PathVariable String tableId, @RequestParam String foodId) {
        orderService.removeFoodOrder(tableId, foodId);
    }
}
