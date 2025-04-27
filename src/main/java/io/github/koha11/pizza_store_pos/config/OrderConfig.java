package io.github.koha11.pizza_store_pos.config;

import io.github.koha11.pizza_store_pos.entity.order.*;
import io.github.koha11.pizza_store_pos.entity.violation.Violation;
import io.github.koha11.pizza_store_pos.entity.violation.ViolationRecord;
import io.github.koha11.pizza_store_pos.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class OrderConfig {
    @Bean
    CommandLineRunner commandLineRunnerForOrder(OrderRepository orderRepo, OrderDetailRepository orderDetailRepo, BookedSeatRepository bookedSeatRepo) {
        return args -> {
            Order order = new Order("OR2704250001", "T01", "EMP001", "EMP001", Timestamp.valueOf(LocalDateTime.now()), Timestamp.valueOf(LocalDateTime.now()), OrderStatus.FINISHED, 0, 0, PaymentMethod.CASH, 0);

            OrderDetail od1 = new OrderDetail("OR2704250001", "F00001", 2, 135000*2);

            OrderDetail od2 = new OrderDetail("OR2704250001", "F00002", 1, 98000*2);

            BookedSeat bookedSeat = new BookedSeat("BS0001", null, null, "Anh Khoa", "0123456789");

            orderRepo.save(order);
            orderDetailRepo.saveAll(List.of(od1, od2));
            bookedSeatRepo.save(bookedSeat);
        };
    }
}
