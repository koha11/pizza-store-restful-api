package io.github.koha11.pizza_store_pos.service;

import io.github.koha11.pizza_store_pos.entity.order.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailService extends GenericService<OrderDetail> {

    public OrderDetailService(JpaRepository<OrderDetail, String> repo) {
        super(repo);
    }

    public void create() {

    }
}
