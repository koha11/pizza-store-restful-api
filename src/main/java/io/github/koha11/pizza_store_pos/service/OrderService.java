package io.github.koha11.pizza_store_pos.service;

import io.github.koha11.pizza_store_pos.entity.mapper.OrderMapper;
import io.github.koha11.pizza_store_pos.entity.order.*;
import io.github.koha11.pizza_store_pos.repository.OrderRepository;
import io.github.koha11.pizza_store_pos.util.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService extends GenericService<Order>{
    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    public SeatService seatService;

    @Autowired
    public OrderMapper orderMapper;

    public OrderService(JpaRepository<Order, String> repo) {
        super(repo);
    }

    //GET METHODS

    public OnTableOrder getCurrentSeatOrder(String seatId) {
        var order = orderRepo.findBySeatId(seatId);

        if(order.isPresent())
        {
            OnTableOrder orderDTO = orderMapper.orderToDTO(order.get());
            List<OnTableOrderDetail> odsDTO = orderDetailService.getAllByOrderId(order.get().getOrderId());

            orderDTO.setFoods(odsDTO);

            return orderDTO;
        }
        else
            throw new IllegalStateException(notFoundIdMsg);
    }

    public List<OnTableOrder> getOrdersByDate(LocalDate date) {
        String todayString = Helper.getDateString(date);

        List<Order> orders = orderRepo.findAllByDateString(todayString);

        return orders.stream().map(order -> orderMapper.orderToDTO(order)).toList();
    }

    public List<OnTableOrder> getAllCurrentSeatOrder() {
        List<String> currentSeatIds = seatService.getCurrentSeatIds();

        return currentSeatIds.stream().map(seatId ->
             getCurrentSeatOrder(seatId)
        ).toList();
    }

    public List<OrderStatistic> getFinishedOrders() {
        List<Order> orders = orderRepo.findAllByStatus();

        return orders.stream().map(order -> {
            OrderStatistic orderStatistic = orderMapper.orderToStatistic(order);

            var foods = orderDetailService.getAllByOrderId(order.getOrderId());

            orderStatistic.setFoods(foods);

            return orderStatistic;
        }).toList();
    }

    // POST METHODS

    public void create(String seatId, String serverId, List<OnTableOrderDetail> ods) {

        String unavailableSeatMsg = "This seat is unavailable!!!";
        if(!seatService.isAvailable(seatId))
            throw new IllegalStateException(unavailableSeatMsg);

        // generate ID
        var listOfT = this.getOrdersByDate(LocalDate.now());
        String id = Helper.generateId(Order.class, listOfT.size());

        // order detail process
        ods.forEach(od -> orderDetailService.create(id,od));

        // order process
        Order order = new Order(id, seatId, serverId, null, Timestamp.valueOf(LocalDateTime.now()), null, OrderStatus.UNFINISHED, 0, 0, null, 0, Timestamp.valueOf(LocalDateTime.now()));

        orderRepo.save(order);

        // seat process
        seatService.toggleStatus(seatId);
    }

    public void addFoodOrder(String seatId, OnTableOrderDetail od) {
        var order = getCurrentSeatOrder(seatId);

        orderDetailService.create(order.getOrderId(), od);
    }

    public void editFoodOrder(String seatId, OnTableOrderDetail odDTO) {
        var order = getCurrentSeatOrder(seatId);

        orderDetailService.editOrderDetail(order.getOrderId(), odDTO);
    }

    // PUT/PATCH METHODS

    public void adjustAmount(boolean isIncrease, String seatId, String foodId) {
        var order = getCurrentSeatOrder(seatId);

        if(isIncrease)
            orderDetailService.increaseAmount(order.getOrderId(), foodId);
        else
            orderDetailService.decreaseAmount(order.getOrderId(), foodId);
    }

    public void payOrder(String seatId, String cashierId, PaymentMethod paymentMethod, float discount, int surcharge) {
        var order = this.getOne(getCurrentSeatOrder(seatId).getOrderId());

        if(order.getStatus() == OrderStatus.UNFINISHED)
        {
            order.setTimeOut(Timestamp.valueOf(LocalDateTime.now()));
            order.setTotal(this.calcOrderTotal(seatId));

            order.setCashierId(cashierId);
            order.setPaymentMethod(paymentMethod);
            order.setDiscount(discount);
            order.setSurcharge(surcharge);

            order.setStatus(OrderStatus.FINISHED);
            seatService.toggleStatus(seatId);
        }
    }

    // DELETE METHODS

    public void removeFoodOrder(String seatId, String foodId) {
        var order = getCurrentSeatOrder(seatId);
        orderDetailService.delete(order.getOrderId(), foodId);
    }

    public void delete(String id) {
        var order = getOne(id);
        seatService.toggleStatus(order.getSeatId());
        super.delete(id);
    }


    // HELPER METHODS

    public int calcOrderTotal(String seatId) {
        var total = 0;

        var order = getCurrentSeatOrder(seatId);

        for (var od: order.getFoods()) {
            total += od.getActualPrice();
        }

        total -= (int) (total * order.getDiscount()) + order.getSurcharge();

        return total;
    }
}
