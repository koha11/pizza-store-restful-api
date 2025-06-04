package io.github.koha11.pizza_store_pos.config;

import io.github.koha11.pizza_store_pos.entity.order.*;
import io.github.koha11.pizza_store_pos.entity.table_reservation.ReservationStatus;
import io.github.koha11.pizza_store_pos.entity.table_reservation.TableReservation;
import io.github.koha11.pizza_store_pos.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class OrderConfig {
    @Bean
    CommandLineRunner commandLineRunnerForOrder(OrderRepository orderRepo, OrderDetailRepository orderDetailRepo, TableReservationRepository tableReservationRepo) {
        return args -> {

            OrderDetail od1 = new OrderDetail("OR2704250001", "F00001", "", 2, 135000*2, Timestamp.valueOf(LocalDateTime.now()));

            OrderDetail od2 = new OrderDetail("OR2704250001", "F00002", "", 3, 98000*3, Timestamp.valueOf(LocalDateTime.now()));
            OrderDetail od3 = new OrderDetail("OR2704250004", "F00002", "", 2, 98000*2, Timestamp.valueOf(LocalDateTime.now()));
            OrderDetail od4 = new OrderDetail("OR2704250005", "F00002", "", 5, 98000*5, Timestamp.valueOf(LocalDateTime.now()));
            OrderDetail od5 = new OrderDetail("OR2704250010", "F00002", "", 4, 98000*4, Timestamp.valueOf(LocalDateTime.now()));

            Order order1 = new Order("OR2704250001", "T01", "EMP001", "EMP001", LocalDateTime.now(), LocalDateTime.now(), OrderStatus.FINISHED, "", 0, 0,  521000, Timestamp.valueOf(LocalDateTime.now()));
            Order order2 = new Order("OR2704250002", "T02", "EMP002", "EMP001",LocalDateTime.parse("2025-02-15T14:00:00"), LocalDateTime.now(), OrderStatus.FINISHED, "", 0, 0,  738000, Timestamp.valueOf(LocalDateTime.parse("2025-02-15T14:00:00")));
            Order order3 = new Order("OR2704250003", "T03", "EMP003", "EMP001", LocalDateTime.parse("2025-05-20T15:00:00"), LocalDateTime.now(), OrderStatus.FINISHED, "", 0, 0,  672000, Timestamp.valueOf(LocalDateTime.parse("2025-05-20T15:00:00")));
            Order order4 = new Order("OR2704250004", "T01", "EMP004", "EMP001", LocalDateTime.parse("2025-05-05T16:00:00"), LocalDateTime.now(), OrderStatus.FINISHED, "", 0, 0,  345000, Timestamp.valueOf(LocalDateTime.parse("2025-05-05T16:00:00")));
            Order order5 = new Order("OR2704250005", "T01", "EMP004", "EMP001", LocalDateTime.parse("2025-05-05T16:00:00"), LocalDateTime.now(), OrderStatus.FINISHED, "", 0, 0,  245000, Timestamp.valueOf(LocalDateTime.parse("2025-05-05T16:00:00")));
            Order order6 = new Order("OR2704250006", "T03", "EMP001", "EMP001", LocalDateTime.now(), LocalDateTime.now(), OrderStatus.FINISHED, "", 0, 0,  321000, Timestamp.valueOf(LocalDateTime.now()));
            Order order7 = new Order("OR2704250007", "T03", "EMP002", "EMP003", LocalDateTime.parse("2025-05-06T16:00:00"), LocalDateTime.now(), OrderStatus.FINISHED, "", 0, 0,  752000, Timestamp.valueOf(LocalDateTime.now()));
            Order order8 = new Order("OR2704250008", "T03", "EMP002", "EMP003", LocalDateTime.parse("2025-05-07T16:00:00"), LocalDateTime.now(), OrderStatus.FINISHED, "", 0, 0,  322000, Timestamp.valueOf(LocalDateTime.now()));
            Order order9 = new Order("OR2704250009", "T03", "EMP002", "EMP003", LocalDateTime.parse("2025-05-09T16:00:00"), LocalDateTime.now(), OrderStatus.FINISHED, "", 0, 0,  922000, Timestamp.valueOf(LocalDateTime.now()));
            Order order10 = new Order("OR2704250010", "T03", "EMP004", "EMP002", LocalDateTime.now(), LocalDateTime.now(), OrderStatus.UNFINISHED, "", 0, 0,  834000, Timestamp.valueOf(LocalDateTime.now()));

            TableReservation tableReservation = new TableReservation("TR0001", "T01", "OR2704250001", "Anh Khoa", "0123456789", "Have children",4, ReservationStatus.FINISHED, LocalDateTime.parse("2025-04-27T18:00:00") ,Timestamp.valueOf(LocalDateTime.now()));

            orderRepo.saveAll(List.of(order1, order2, order3, order4, order5, order6, order7, order8, order9, order10));
            orderDetailRepo.saveAll(List.of(od1, od2));
            tableReservationRepo.save(tableReservation);
        };
    }
}
