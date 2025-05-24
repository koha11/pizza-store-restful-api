package io.github.koha11.pizza_store_pos.config;

import io.github.koha11.pizza_store_pos.entity.food.Food;
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

            OrderDetail od1 = new OrderDetail("OR2704250001", "F00001", "SIZE_M", "", 2, 135000*2, Timestamp.valueOf(LocalDateTime.now()));

            OrderDetail od2 = new OrderDetail("OR2704250001", "F00002", "SIZE_M", "", 1, 98000*2, Timestamp.valueOf(LocalDateTime.now()));

            Order order1 = new Order("OR2704250001", "T01", "EMP001", "EMP001", LocalDateTime.now(), LocalDateTime.now(), OrderStatus.FINISHED, "", 0, 0, PaymentMethod.CASH, 521000, Timestamp.valueOf(LocalDateTime.now()));
            Order order2 = new Order("OR2704250002", "T02", "EMP002", "EMP001",LocalDateTime.parse("2025-02-15T14:00:00"), LocalDateTime.now(), OrderStatus.FINISHED, "", 0, 0, PaymentMethod.CASH, 738000, Timestamp.valueOf(LocalDateTime.parse("2025-02-15T14:00:00")));
            Order order3 = new Order("OR2704250003", "T03", "EMP003", "EMP001", LocalDateTime.parse("2025-05-20T15:00:00"), LocalDateTime.now(), OrderStatus.FINISHED, "", 0, 0, PaymentMethod.CASH, 672000, Timestamp.valueOf(LocalDateTime.parse("2025-05-20T15:00:00")));
            Order order4 = new Order("OR2704250004", "T01", "EMP004", "EMP001", LocalDateTime.parse("2025-05-05T16:00:00"), LocalDateTime.now(), OrderStatus.FINISHED, "", 0, 0, PaymentMethod.CASH, 345000, Timestamp.valueOf(LocalDateTime.parse("2025-05-05T16:00:00")));

            BookedSeat bookedSeat = new BookedSeat("BS0001", "T01", "OR2704250001", "Anh Khoa", "0123456789", 4, LocalDateTime.parse("2025-04-27T18:00:00") ,Timestamp.valueOf(LocalDateTime.now()));

            orderRepo.saveAll(List.of(order1, order2, order3, order4));
            orderDetailRepo.saveAll(List.of(od1, od2));
            bookedSeatRepo.save(bookedSeat);
        };
    }
}
