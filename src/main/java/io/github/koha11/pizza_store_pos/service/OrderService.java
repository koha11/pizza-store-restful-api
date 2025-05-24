package io.github.koha11.pizza_store_pos.service;

import io.github.koha11.pizza_store_pos.entity.mapper.OrderMapper;
import io.github.koha11.pizza_store_pos.entity.order.*;
import io.github.koha11.pizza_store_pos.repository.OrderRepository;
import io.github.koha11.pizza_store_pos.util.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.*;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
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
    @Lazy
    public OrderMapper orderMapper;

    private final String unavailableSeatMsg = "This seat is unavailable!!!";

    public OrderService(JpaRepository<Order, String> repo) {
        super(repo);
    }

    //GET METHODS

    public List<OrderStatistic> getOrdersByMonthAndYear(Month month, int year, boolean isCurrent) {
        LocalDateTime datetimeStart;
        LocalDateTime datetimeEnd;
        if(isCurrent) {
            LocalDate today = LocalDate.now();
            datetimeStart = today.atTime(0, 0, 0);
            datetimeEnd = today.atTime(23, 59, 59);
        } else {
            LocalDate startDate = LocalDate.of(year,month, 1);
            LocalDate endDate = LocalDate.of(year,month, YearMonth.of(year, month).lengthOfMonth());
            datetimeStart = startDate.atStartOfDay();
            datetimeEnd = endDate.atTime(23, 59, 59);
        }
        List<Order> orders = orderRepo.findAllByDate(datetimeStart, datetimeEnd);
        orders = orders.stream().filter(order -> order.getStatus() == OrderStatus.FINISHED).toList();
        return orders.stream().map(order -> orderMapper.orderToStatistic(order)).toList();
    }



    public List<OrderStatistic> getOrders(OrderStatus status, LocalDate dateStart, LocalDate dateEnd) {
        List<Order> orders;

        dateStart = dateStart == null ? LocalDate.from(getAll().getFirst().getTimeIn()) : dateStart;

        dateEnd = dateEnd == null ? LocalDate.from(getAll().getLast().getTimeIn()) : dateEnd;

        LocalDateTime datetimeStart = LocalDateTime.of(dateStart, LocalTime.parse("00:00:00"));

        LocalDateTime datetimeEnd = LocalDateTime.of(dateEnd, LocalTime.parse("23:59:59"));

        orders = orderRepo.findAllByDate(datetimeStart, datetimeEnd);

        if(status != null)
            orders = orders.stream().filter(order -> order.getStatus() == status).toList();

        return orders.stream().map(order ->
             orderMapper.orderToStatistic(order)
        ).toList();
    }

    public OnTableOrder getCurrentSeatOrder(String seatId) {
        var order = getOrderBySeatId(seatId);

        return orderMapper.orderToDTO(order);
    }

    public Order getOrderBySeatId(String seatId) {
        var order = orderRepo.findBySeatId(seatId);

        if(order.isPresent())
        {
            return order.get();
        }
        else
            throw new IllegalStateException(notFoundIdMsg);
    }

    public OrderStatistic getOrderByOrderId(String orderId) {
        var order = orderRepo.findById(orderId);

        if(order.isPresent())
        {
            return orderMapper.orderToStatistic(order.get());
        }
        else
            throw new IllegalStateException(notFoundIdMsg);
    }

    public List<OnTableOrder> getOrdersByDate(LocalDate date) {
        String todayString = Helper.getDateString(date);

        List<Order> orders = orderRepo.findAllByDateString(todayString);

        return orders.stream().map(order -> orderMapper.orderToDTO(order)).toList();
    }

    // POST METHODS

    public OnTableOrder create(String seatId, String serverId, String note, List<OnTableOrderDetail> ods) {

        if(!seatService.isAvailable(seatId))
            throw new IllegalStateException(unavailableSeatMsg);

        // generate ID
        var listOfT = this.getOrdersByDate(LocalDate.now());
        String id = Helper.generateId(Order.class, listOfT.size());

        // order detail process
        ods.forEach(od -> orderDetailService.create(id,od));

        // order process
        Order order = new Order(id, seatId, serverId, null, LocalDateTime.now(), null, OrderStatus.UNFINISHED, note, 0, 0, null, calcOrderTotal(ods, 0, 0), Timestamp.valueOf(LocalDateTime.now()));

        orderRepo.save(order);

        // seat process
        seatService.toggleStatus(seatId);

        return orderMapper.orderToDTO(order);
    }

    public OnTableOrderDetail addFoodOrder(String seatId, OnTableOrderDetail od) {
        var order = getCurrentSeatOrder(seatId);

        orderDetailService.create(order.getOrderId(), od);

        return od;
    }

    // PUT/PATCH METHODS

    public OnTableOrder editOnTableOrder(OnTableOrder orderDTO) {
        Order order = getOrderBySeatId(orderDTO.getSeatId());
        OnTableOrder oldOrder = getCurrentSeatOrder(order.getSeatId());

        if(orderDTO.getDiscount() != oldOrder.getDiscount())
            order.setDiscount(orderDTO.getDiscount());

        if(orderDTO.getSurcharge() != oldOrder.getSurcharge())
            order.setSurcharge(orderDTO.getSurcharge());

        if(!orderDTO.getNote().equals(oldOrder.getNote()))
            order.setNote(orderDTO.getNote());

        update(order.getOrderId(), order);
        orderDetailService.update(orderDTO.getFoods());

        List<String> oldFoodIds = orderDTO.getFoods().stream().map(OnTableOrderDetail::getFoodId).toList();

        // remove food
        oldOrder.getFoods().forEach(oldFood -> {
            if(!oldFoodIds.contains(oldFood.getFoodId()))
            {
                orderDetailService.delete(oldFood.getOrderId(), oldFood.getFoodId());
            }
        });

        // neu xoa het tat ca mon
        if(orderDTO.getFoods().isEmpty())
        {
            delete(order.getOrderId());
            OnTableOrder emptyOrderDTO = new OnTableOrder();
            emptyOrderDTO.setSeatId(order.getSeatId());
            emptyOrderDTO.setServerId(order.getServerId());
            emptyOrderDTO.setOrderId("");
            emptyOrderDTO.setFoods(new ArrayList<>());
            return emptyOrderDTO;
        }

       return orderMapper.orderToDTO(order);
    }

    public void editFoodOrder(String seatId, OnTableOrderDetail odDTO) {
        var order = getCurrentSeatOrder(seatId);

        orderDetailService.editOrderDetail(order.getOrderId(), odDTO);
    }

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
            order.setTimeOut(LocalDateTime.now());
            order.setTotal(this.calcOrderTotal(seatId));

            order.setCashierId(cashierId);
            order.setPaymentMethod(paymentMethod);
            order.setDiscount(discount);
            order.setSurcharge(surcharge);

            order.setStatus(OrderStatus.FINISHED);
            seatService.toggleStatus(seatId);
        }
    }

    public void changeSeat(String seatId, String changedSeatId) {
        var order = getOrderBySeatId(seatId);

        if (seatService.isAvailable(changedSeatId))
        {
            order.setSeatId(changedSeatId);
            seatService.toggleStatus(changedSeatId);
            seatService.toggleStatus(seatId);
            orderRepo.save(order);
        }
        else
            throw new IllegalStateException(unavailableSeatMsg);
    }

    public void moveFoodsToDiffSeat(String seatId, List<OnTableOrderDetail> ods, String changedSeatId, String serverId) {
        var order = getOrderBySeatId(seatId);

        ods.forEach(od -> {
            orderDetailService.delete(order.getOrderId(),od.getFoodId());
        });

        order.setTotal(calcOrderTotal(seatId));

        create(changedSeatId,serverId,order.getNote(),ods);

        orderRepo.save(order);
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

    // Tinh tong sau khi da order xong
    public int calcOrderTotal(String seatId) {
        var total = 0;

        var order = getCurrentSeatOrder(seatId);

        for (var od: order.getFoods()) {
            total += od.getActualPrice();
        }

        total -= (int) (total * order.getDiscount()) + order.getSurcharge();

        return total;
    }

    // Tinh tong khi order
    public int calcOrderTotal(List<OnTableOrderDetail> ods, int surcharge, float discount) {
        var total = 0;

        for (var od: ods) {
            total += od.getActualPrice();
        }

        total = total - (int) (total * discount) + surcharge;

        return total;
    }
}
