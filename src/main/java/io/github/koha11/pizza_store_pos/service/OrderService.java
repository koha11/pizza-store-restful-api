package io.github.koha11.pizza_store_pos.service;

import io.github.koha11.pizza_store_pos.entity.order.Order;
import io.github.koha11.pizza_store_pos.entity.order.OrderDetail;
import io.github.koha11.pizza_store_pos.repository.OrderDetailRepository;
import io.github.koha11.pizza_store_pos.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private OrderDetailRepository orderDetailRepo;

    public List<Order> getAll() {
        return orderRepo.findAll();
    }

    public List<OrderDetail> getOrderDetails(String orderId) {
        return orderDetailRepo.findByOrderId(orderId);
    }
}
