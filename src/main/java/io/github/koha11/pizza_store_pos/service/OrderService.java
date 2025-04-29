package io.github.koha11.pizza_store_pos.service;

import io.github.koha11.pizza_store_pos.entity.food.Food;
import io.github.koha11.pizza_store_pos.entity.order.Order;
import io.github.koha11.pizza_store_pos.entity.order.OrderDetail;
import io.github.koha11.pizza_store_pos.entity.order.OrderStatus;
import io.github.koha11.pizza_store_pos.entity.order.PaymentMethod;
import io.github.koha11.pizza_store_pos.repository.OrderDetailRepository;
import io.github.koha11.pizza_store_pos.repository.OrderRepository;
import io.github.koha11.pizza_store_pos.util.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService extends GenericService<Order>{
    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private OrderDetailRepository orderDetailRepo;

    @Autowired
    private FoodService foodService;

    public OrderService(JpaRepository<Order, String> repo) {
        super(repo);
    }

    public void create(String seatId, String serverId) {
        var listOfT = this.getAll();
        String id = Helper.generateId(Order.class, listOfT.size());
        Order order = new Order(id, seatId, serverId, null, Timestamp.valueOf(LocalDateTime.now()), null, OrderStatus.UNFINISHED, 0, 0, null, 0);

        orderRepo.save(order);
    }

    public List<OrderDetail> getOrderDetails(String orderId) {
        return orderDetailRepo.findByOrderId(orderId);
    }

    public void addFoods(List<OrderDetail> orderDetails, String orderId) {
        var order = this.getOne(orderId);

        if(order.getStatus() == OrderStatus.UNFINISHED)
        {
            orderDetails.forEach(orderDetail -> {
                orderDetail.setOrderId(orderId);
                orderDetail.setActualPrice(1);

            });

            orderDetailRepo.saveAll(orderDetails);
        }
    }

    public int calcActualPrice(String foodId, int amount) {
        int actualPrice = 0;

        var food = foodService.getOne(foodId);



        return actualPrice;
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
        var orderDetails = this.getOrderDetails(order.getOrderId());
        var total = 0;

        for (var od: orderDetails) {
            total += od.getActualPrice();
        }

        total -= (int) (total * order.getDiscount()) + order.getSurcharge();

        return total;
    }
}
