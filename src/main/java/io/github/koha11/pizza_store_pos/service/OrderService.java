package io.github.koha11.pizza_store_pos.service;

import io.github.koha11.pizza_store_pos.entity.mapper.OrderMapper;
import io.github.koha11.pizza_store_pos.entity.order.*;
import io.github.koha11.pizza_store_pos.repository.OrderRepository;
import io.github.koha11.pizza_store_pos.util.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService extends GenericService<Order>{
    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private FoodService foodService;

    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    public OrderMapper orderMapper;

    public OrderService(JpaRepository<Order, String> repo) {
        super(repo);
    }

    public void create(String seatId, String serverId) {
        var listOfT = this.getAll();
        String id = Helper.generateId(Order.class, listOfT.size());
        Order order = new Order(id, seatId, serverId, null, Timestamp.valueOf(LocalDateTime.now()), null, OrderStatus.UNFINISHED, 0, 0, null, 0);

        orderRepo.save(order);
    }

    public OnTableOrder getCurrentSeatOrder(String seatId) {
        var order = orderRepo.findBySeatId(seatId);

        if(order.isPresent())
        {
            OnTableOrder orderDTO = orderMapper.orderToDTO(order.get());
            List<OnTableOrderDetail> odsDTO = orderDetailService.getByOrderId(order.get().getOrderId());

            orderDTO.setFoods(odsDTO);

            return orderDTO;
        }
        else
            throw new IllegalStateException(notFoundIdMsg);
    }

    public void adjustAmount(boolean isIncrease, String seatId, String foodId) {
        var order = getCurrentSeatOrder(seatId);

        if(isIncrease)
            orderDetailService.increaseAmount(order.getOrderId(), foodId);
        else
            orderDetailService.decreaseAmount(order.getOrderId(), foodId);
    }

    public void deleteOrderDetail(String seatId, String foodId) {
        var order = getCurrentSeatOrder(seatId);

        orderDetailService.delete(order.getOrderId(), foodId);
    }

    public void addFoods(String seatId, List<OrderDetail> ods) {
        var order = this.getOne(seatId);

        if(order.getStatus() == OrderStatus.UNFINISHED)
        {
               ods.forEach(od -> {
                   orderDetailService.create(od);
               });
        }
    }


    public void payOrder(String orderId, String cashierId, PaymentMethod paymentMethod, float discount, int surcharge) {
        var order = this.getOne(orderId);

        if(order.getStatus() == OrderStatus.UNFINISHED)
        {
            order.setStatus(OrderStatus.FINISHED);
            order.setCashierId(cashierId);
            order.setPaymentMethod(paymentMethod);
            order.setDiscount(discount);
            order.setSurcharge(surcharge);

            order.setTimeOut(Timestamp.valueOf(LocalDateTime.now()));
            order.setTotal(this.calcOrderTotal(order));
        }
    }

    public int calcOrderTotal(Order order) {
        var total = 0;

//        var orderDetails = this.getOrderDetails(order.getOrderId());
//
//        for (var od: orderDetails) {
//            total += od.getActualPrice();
//        }
//      
//        total -= (int) (total * order.getDiscount()) + order.getSurcharge();

        return total;
    }
}
