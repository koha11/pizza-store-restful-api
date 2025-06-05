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
            TableReservation tableReservation = new TableReservation("TR0001", "T01", "OR2704250001", "Anh Khoa", "0123456789", "Have children",4, ReservationStatus.FINISHED, LocalDateTime.parse("2025-04-27T18:00:00") ,Timestamp.valueOf(LocalDateTime.now()));

// ------------------------
// December 2024 Orders (10)
// ------------------------

// Order 1: 01/12/2024, Pumpkin Soup (F00001) x2
            OrderDetail od1 = new OrderDetail(
                    "OR0112240001",
                    "F00001",
                    "",
                    2,
                    49000 * 2,
                    Timestamp.valueOf(LocalDateTime.of(2024, 12, 1, 12, 0))
            );
            Order order1 = new Order(
                    "OR0112240001",
                    "T01",
                    "EMP004",
                    "EMP001",
                    LocalDateTime.of(2024, 12, 1, 12, 0),
                    LocalDateTime.of(2024, 12, 1, 12, 0),
                    OrderStatus.FINISHED,
                    "",
                    0f,
                    0,
                    49000 * 2,
                    Timestamp.valueOf(LocalDateTime.of(2024, 12, 1, 12, 0))
            );

// Order 2: 02/12/2024, Seafood Soup (F00002) x1
            OrderDetail od2 = new OrderDetail(
                    "OR0212240001",
                    "F00002",
                    "",
                    1,
                    115000 * 1,
                    Timestamp.valueOf(LocalDateTime.of(2024, 12, 2, 12, 0))
            );
            Order order2 = new Order(
                    "OR0212240001",
                    "T02",
                    "EMP004",
                    "EMP001",
                    LocalDateTime.of(2024, 12, 2, 12, 0),
                    LocalDateTime.of(2024, 12, 2, 12, 0),
                    OrderStatus.FINISHED,
                    "",
                    0f,
                    0,
                    115000 * 1,
                    Timestamp.valueOf(LocalDateTime.of(2024, 12, 2, 12, 0))
            );

// Order 3: 03/12/2024, Saute Di Vongole (F00003) x1
            OrderDetail od3 = new OrderDetail(
                    "OR0312240001",
                    "F00003",
                    "",
                    1,
                    99000 * 1,
                    Timestamp.valueOf(LocalDateTime.of(2024, 12, 3, 12, 0))
            );
            Order order3 = new Order(
                    "OR0312240001",
                    "T03",
                    "EMP004",
                    "EMP001",
                    LocalDateTime.of(2024, 12, 3, 12, 0),
                    LocalDateTime.of(2024, 12, 3, 12, 0),
                    OrderStatus.FINISHED,
                    "",
                    0f,
                    0,
                    99000 * 1,
                    Timestamp.valueOf(LocalDateTime.of(2024, 12, 3, 12, 0))
            );

// Order 4: 04/12/2024, Misti Bruschette (F00004) x1
            OrderDetail od4 = new OrderDetail(
                    "OR0412240001",
                    "F00004",
                    "",
                    1,
                    98000 * 1,
                    Timestamp.valueOf(LocalDateTime.of(2024, 12, 4, 12, 0))
            );
            Order order4 = new Order(
                    "OR0412240001",
                    "T04",
                    "EMP004",
                    "EMP001",
                    LocalDateTime.of(2024, 12, 4, 12, 0),
                    LocalDateTime.of(2024, 12, 4, 12, 0),
                    OrderStatus.FINISHED,
                    "",
                    0f,
                    0,
                    98000 * 1,
                    Timestamp.valueOf(LocalDateTime.of(2024, 12, 4, 12, 0))
            );

// Order 5: 05/12/2024, Garlic Bread (F00005) x1
            OrderDetail od5 = new OrderDetail(
                    "OR0512240001",
                    "F00005",
                    "",
                    1,
                    38000 * 1,
                    Timestamp.valueOf(LocalDateTime.of(2024, 12, 5, 12, 0))
            );
            Order order5 = new Order(
                    "OR0512240001",
                    "T05",
                    "EMP004",
                    "EMP001",
                    LocalDateTime.of(2024, 12, 5, 12, 0),
                    LocalDateTime.of(2024, 12, 5, 12, 0),
                    OrderStatus.FINISHED,
                    "",
                    0f,
                    0,
                    38000 * 1,
                    Timestamp.valueOf(LocalDateTime.of(2024, 12, 5, 12, 0))
            );

// Order 6: 06/12/2024, Insalata Siciliana (F00006) x1
            OrderDetail od6 = new OrderDetail(
                    "OR0612240001",
                    "F00006",
                    "",
                    1,
                    85000 * 1,
                    Timestamp.valueOf(LocalDateTime.of(2024, 12, 6, 12, 0))
            );
            Order order6 = new Order(
                    "OR0612240001",
                    "T06",
                    "EMP004",
                    "EMP001",
                    LocalDateTime.of(2024, 12, 6, 12, 0),
                    LocalDateTime.of(2024, 12, 6, 12, 0),
                    OrderStatus.FINISHED,
                    "",
                    0f,
                    0,
                    85000 * 1,
                    Timestamp.valueOf(LocalDateTime.of(2024, 12, 6, 12, 0))
            );

// Order 7: 07/12/2024, Shrimp Salad (F00007) x1
            OrderDetail od7 = new OrderDetail(
                    "OR0712240001",
                    "F00007",
                    "",
                    1,
                    145000 * 1,
                    Timestamp.valueOf(LocalDateTime.of(2024, 12, 7, 12, 0))
            );
            Order order7 = new Order(
                    "OR0712240001",
                    "T07",
                    "EMP004",
                    "EMP001",
                    LocalDateTime.of(2024, 12, 7, 12, 0),
                    LocalDateTime.of(2024, 12, 7, 12, 0),
                    OrderStatus.FINISHED,
                    "",
                    0f,
                    0,
                    145000 * 1,
                    Timestamp.valueOf(LocalDateTime.of(2024, 12, 7, 12, 0))
            );

// Order 8: 08/12/2024, Beef Carpaccio (F00008) x1
            OrderDetail od8 = new OrderDetail(
                    "OR0812240001",
                    "F00008",
                    "",
                    1,
                    145000 * 1,
                    Timestamp.valueOf(LocalDateTime.of(2024, 12, 8, 12, 0))
            );
            Order order8 = new Order(
                    "OR0812240001",
                    "T08",
                    "EMP004",
                    "EMP001",
                    LocalDateTime.of(2024, 12, 8, 12, 0),
                    LocalDateTime.of(2024, 12, 8, 12, 0),
                    OrderStatus.FINISHED,
                    "",
                    0f,
                    0,
                    145000 * 1,
                    Timestamp.valueOf(LocalDateTime.of(2024, 12, 8, 12, 0))
            );

// Order 9: 09/12/2024, Spaghetti Bolognese (F00009) x1
            OrderDetail od9 = new OrderDetail(
                    "OR0912240001",
                    "F00009",
                    "",
                    1,
                    127000 * 1,
                    Timestamp.valueOf(LocalDateTime.of(2024, 12, 9, 12, 0))
            );
            Order order9 = new Order(
                    "OR0912240001",
                    "T09",
                    "EMP004",
                    "EMP001",
                    LocalDateTime.of(2024, 12, 9, 12, 0),
                    LocalDateTime.of(2024, 12, 9, 12, 0),
                    OrderStatus.FINISHED,
                    "",
                    0f,
                    0,
                    127000 * 1,
                    Timestamp.valueOf(LocalDateTime.of(2024, 12, 9, 12, 0))
            );

// Order 10: 10/12/2024, Spaghetti Pomodoro (F00010) x1
            OrderDetail od10 = new OrderDetail(
                    "OR1012240001",
                    "F00010",
                    "",
                    1,
                    98000 * 1,
                    Timestamp.valueOf(LocalDateTime.of(2024, 12, 10, 12, 0))
            );
            Order order10 = new Order(
                    "OR1012240001",
                    "T10",
                    "EMP004",
                    "EMP001",
                    LocalDateTime.of(2024, 12, 10, 12, 0),
                    LocalDateTime.of(2024, 12, 10, 12, 0),
                    OrderStatus.FINISHED,
                    "",
                    0f,
                    0,
                    98000 * 1,
                    Timestamp.valueOf(LocalDateTime.of(2024, 12, 10, 12, 0))
            );

// ---------------------
// May 2025 Orders (10)
// ---------------------

// Order 11: 01/05/2025, Spaghetti Pesto (F00011) x1
            OrderDetail od11 = new OrderDetail(
                    "OR0105250001",
                    "F00011",
                    "",
                    1,
                    169000 * 1,
                    Timestamp.valueOf(LocalDateTime.of(2025, 5, 1, 12, 0))
            );
            Order order11 = new Order(
                    "OR0105250001",
                    "T01",
                    "EMP004",
                    "EMP001",
                    LocalDateTime.of(2025, 5, 1, 12, 0),
                    LocalDateTime.of(2025, 5, 1, 12, 0),
                    OrderStatus.FINISHED,
                    "",
                    0f,
                    0,
                    169000 * 1,
                    Timestamp.valueOf(LocalDateTime.of(2025, 5, 1, 12, 0))
            );

// Order 12: 02/05/2025, Spaghetti All'acciuga (F00012) x1
            OrderDetail od12 = new OrderDetail(
                    "OR0205250001",
                    "F00012",
                    "",
                    1,
                    125000 * 1,
                    Timestamp.valueOf(LocalDateTime.of(2025, 5, 2, 12, 0))
            );
            Order order12 = new Order(
                    "OR0205250001",
                    "T02",
                    "EMP004",
                    "EMP001",
                    LocalDateTime.of(2025, 5, 2, 12, 0),
                    LocalDateTime.of(2025, 5, 2, 12, 0),
                    OrderStatus.FINISHED,
                    "",
                    0f,
                    0,
                    125000 * 1,
                    Timestamp.valueOf(LocalDateTime.of(2025, 5, 2, 12, 0))
            );

// Order 13: 03/05/2025, Spaghetti Carbonara (F00013) x1
            OrderDetail od13 = new OrderDetail(
                    "OR0305250001",
                    "F00013",
                    "",
                    1,
                    137000 * 1,
                    Timestamp.valueOf(LocalDateTime.of(2025, 5, 3, 12, 0))
            );
            Order order13 = new Order(
                    "OR0305250001",
                    "T03",
                    "EMP004",
                    "EMP001",
                    LocalDateTime.of(2025, 5, 3, 12, 0),
                    LocalDateTime.of(2025, 5, 3, 12, 0),
                    OrderStatus.FINISHED,
                    "",
                    0f,
                    0,
                    137000 * 1,
                    Timestamp.valueOf(LocalDateTime.of(2025, 5, 3, 12, 0))
            );

// Order 14: 04/05/2025, Spaghetti Vongole (F00014) x1
            OrderDetail od14 = new OrderDetail(
                    "OR0405250001",
                    "F00014",
                    "",
                    1,
                    145000 * 1,
                    Timestamp.valueOf(LocalDateTime.of(2025, 5, 4, 12, 0))
            );
            Order order14 = new Order(
                    "OR0405250001",
                    "T04",
                    "EMP004",
                    "EMP001",
                    LocalDateTime.of(2025, 5, 4, 12, 0),
                    LocalDateTime.of(2025, 5, 4, 12, 0),
                    OrderStatus.FINISHED,
                    "",
                    0f,
                    0,
                    145000 * 1,
                    Timestamp.valueOf(LocalDateTime.of(2025, 5, 4, 12, 0))
            );

// Order 15: 05/05/2025, Spaghetti Marinara (F00015) x1
            OrderDetail od15 = new OrderDetail(
                    "OR0505250001",
                    "F00015",
                    "",
                    1,
                    179000 * 1,
                    Timestamp.valueOf(LocalDateTime.of(2025, 5, 5, 12, 0))
            );
            Order order15 = new Order(
                    "OR0505250001",
                    "T05",
                    "EMP004",
                    "EMP001",
                    LocalDateTime.of(2025, 5, 5, 12, 0),
                    LocalDateTime.of(2025, 5, 5, 12, 0),
                    OrderStatus.FINISHED,
                    "",
                    0f,
                    0,
                    179000 * 1,
                    Timestamp.valueOf(LocalDateTime.of(2025, 5, 5, 12, 0))
            );

// Order 16: 06/05/2025, Penne Al Forno (F00016) x1
            OrderDetail od16 = new OrderDetail(
                    "OR0605250001",
                    "F00016",
                    "",
                    1,
                    165000 * 1,
                    Timestamp.valueOf(LocalDateTime.of(2025, 5, 6, 12, 0))
            );
            Order order16 = new Order(
                    "OR0605250001",
                    "T06",
                    "EMP004",
                    "EMP001",
                    LocalDateTime.of(2025, 5, 6, 12, 0),
                    LocalDateTime.of(2025, 5, 6, 12, 0),
                    OrderStatus.FINISHED,
                    "",
                    0f,
                    0,
                    165000 * 1,
                    Timestamp.valueOf(LocalDateTime.of(2025, 5, 6, 12, 0))
            );

// Order 17: 07/05/2025, Penne Arrabbiata (F00017) x1
            OrderDetail od17 = new OrderDetail(
                    "OR0705250001",
                    "F00017",
                    "",
                    1,
                    98000 * 1,
                    Timestamp.valueOf(LocalDateTime.of(2025, 5, 7, 12, 0))
            );
            Order order17 = new Order(
                    "OR0705250001",
                    "T07",
                    "EMP004",
                    "EMP001",
                    LocalDateTime.of(2025, 5, 7, 12, 0),
                    LocalDateTime.of(2025, 5, 7, 12, 0),
                    OrderStatus.FINISHED,
                    "",
                    0f,
                    0,
                    98000 * 1,
                    Timestamp.valueOf(LocalDateTime.of(2025, 5, 7, 12, 0))
            );

// Order 18: 08/05/2025, Penne Puttanesca (F00018) x1
            OrderDetail od18 = new OrderDetail(
                    "OR0805250001",
                    "F00018",
                    "",
                    1,
                    137000 * 1,
                    Timestamp.valueOf(LocalDateTime.of(2025, 5, 8, 12, 0))
            );
            Order order18 = new Order(
                    "OR0805250001",
                    "T08",
                    "EMP004",
                    "EMP001",
                    LocalDateTime.of(2025, 5, 8, 12, 0),
                    LocalDateTime.of(2025, 5, 8, 12, 0),
                    OrderStatus.FINISHED,
                    "",
                    0f,
                    0,
                    137000 * 1,
                    Timestamp.valueOf(LocalDateTime.of(2025, 5, 8, 12, 0))
            );

// Order 19: 09/05/2025, Penne Alfredo (F00019) x1
            OrderDetail od19 = new OrderDetail(
                    "OR0905250001",
                    "F00019",
                    "",
                    1,
                    137000 * 1,
                    Timestamp.valueOf(LocalDateTime.of(2025, 5, 9, 12, 0))
            );
            Order order19 = new Order(
                    "OR0905250001",
                    "T09",
                    "EMP004",
                    "EMP001",
                    LocalDateTime.of(2025, 5, 9, 12, 0),
                    LocalDateTime.of(2025, 5, 9, 12, 0),
                    OrderStatus.FINISHED,
                    "",
                    0f,
                    0,
                    137000 * 1,
                    Timestamp.valueOf(LocalDateTime.of(2025, 5, 9, 12, 0))
            );

// Order 20: 10/05/2025, Penne Boscaiola (F00020) x1
            OrderDetail od20 = new OrderDetail(
                    "OR1005250001",
                    "F00020",
                    "",
                    1,
                    169000 * 1,
                    Timestamp.valueOf(LocalDateTime.of(2025, 5, 10, 12, 0))
            );
            Order order20 = new Order(
                    "OR1005250001",
                    "T10",
                    "EMP004",
                    "EMP001",
                    LocalDateTime.of(2025, 5, 10, 12, 0),
                    LocalDateTime.of(2025, 5, 10, 12, 0),
                    OrderStatus.FINISHED,
                    "",
                    0f,
                    0,
                    169000 * 1,
                    Timestamp.valueOf(LocalDateTime.of(2025, 5, 10, 12, 0))
            );

// -----------------------------------------------
// June 2025 Orders (before 06/06/2025) (10 orders)
// -----------------------------------------------

// Day 1 (01/06/2025), two orders

// Order 21: 01/06/2025, Penne Al Salmone (F00021) x1
            OrderDetail od21 = new OrderDetail(
                    "OR0106250001",
                    "F00021",
                    "",
                    1,
                    179000 * 1,
                    Timestamp.valueOf(LocalDateTime.of(2025, 6, 1, 12, 0))
            );
            Order order21 = new Order(
                    "OR0106250001",
                    "T01",
                    "EMP004",
                    "EMP001",
                    LocalDateTime.of(2025, 6, 1, 12, 0),
                    LocalDateTime.of(2025, 6, 1, 12, 0),
                    OrderStatus.FINISHED,
                    "",
                    0f,
                    0,
                    179000 * 1,
                    Timestamp.valueOf(LocalDateTime.of(2025, 6, 1, 12, 0))
            );

// Order 22: 01/06/2025, Penne 4 Formaggi (F00022) x1
            OrderDetail od22 = new OrderDetail(
                    "OR0106250002",
                    "F00022",
                    "",
                    1,
                    189000 * 1,
                    Timestamp.valueOf(LocalDateTime.of(2025, 6, 1, 13, 0))
            );
            Order order22 = new Order(
                    "OR0106250002",
                    "T02",
                    "EMP004",
                    "EMP001",
                    LocalDateTime.of(2025, 6, 1, 13, 0),
                    LocalDateTime.of(2025, 6, 1, 13, 0),
                    OrderStatus.FINISHED,
                    "",
                    0f,
                    0,
                    189000 * 1,
                    Timestamp.valueOf(LocalDateTime.of(2025, 6, 1, 13, 0))
            );

// Day 2 (02/06/2025), two orders

// Order 23: 02/06/2025, Lasagna (F00023) x1
            OrderDetail od23 = new OrderDetail(
                    "OR0206250001",
                    "F00023",
                    "",
                    1,
                    169000 * 1,
                    Timestamp.valueOf(LocalDateTime.of(2025, 6, 2, 12, 0))
            );
            Order order23 = new Order(
                    "OR0206250001",
                    "T03",
                    "EMP004",
                    "EMP001",
                    LocalDateTime.of(2025, 6, 2, 12, 0),
                    LocalDateTime.of(2025, 6, 2, 12, 0),
                    OrderStatus.FINISHED,
                    "",
                    0f,
                    0,
                    169000 * 1,
                    Timestamp.valueOf(LocalDateTime.of(2025, 6, 2, 12, 0))
            );

// Order 24: 02/06/2025, Fettuccine Contadina (F00024) x1
            OrderDetail od24 = new OrderDetail(
                    "OR0206250002",
                    "F00024",
                    "",
                    1,
                    169000 * 1,
                    Timestamp.valueOf(LocalDateTime.of(2025, 6, 2, 13, 0))
            );
            Order order24 = new Order(
                    "OR0206250002",
                    "T04",
                    "EMP004",
                    "EMP001",
                    LocalDateTime.of(2025, 6, 2, 13, 0),
                    LocalDateTime.of(2025, 6, 2, 13, 0),
                    OrderStatus.FINISHED,
                    "",
                    0f,
                    0,
                    169000 * 1,
                    Timestamp.valueOf(LocalDateTime.of(2025, 6, 2, 13, 0))
            );

// Day 3 (03/06/2025), two orders

// Order 25: 03/06/2025, Fettuccine Salmone (F00025) x1
            OrderDetail od25 = new OrderDetail(
                    "OR0306250001",
                    "F00025",
                    "",
                    1,
                    179000 * 1,
                    Timestamp.valueOf(LocalDateTime.of(2025, 6, 3, 12, 0))
            );
            Order order25 = new Order(
                    "OR0306250001",
                    "T05",
                    "EMP004",
                    "EMP001",
                    LocalDateTime.of(2025, 6, 3, 12, 0),
                    LocalDateTime.of(2025, 6, 3, 12, 0),
                    OrderStatus.FINISHED,
                    "",
                    0f,
                    0,
                    179000 * 1,
                    Timestamp.valueOf(LocalDateTime.of(2025, 6, 3, 12, 0))
            );

// Order 26: 03/06/2025, Gnocchi Al Pomodoro (F00026) x1
            OrderDetail od26 = new OrderDetail(
                    "OR0306250002",
                    "F00026",
                    "",
                    1,
                    169000 * 1,
                    Timestamp.valueOf(LocalDateTime.of(2025, 6, 3, 13, 0))
            );
            Order order26 = new Order(
                    "OR0306250002",
                    "T06",
                    "EMP004",
                    "EMP001",
                    LocalDateTime.of(2025, 6, 3, 13, 0),
                    LocalDateTime.of(2025, 6, 3, 13, 0),
                    OrderStatus.FINISHED,
                    "",
                    0f,
                    0,
                    169000 * 1,
                    Timestamp.valueOf(LocalDateTime.of(2025, 6, 3, 13, 0))
            );

// Day 4 (04/06/2025), two orders

// Order 27: 04/06/2025, Gnocchi Gorgonzola (F00027) x1
            OrderDetail od27 = new OrderDetail(
                    "OR0406250001",
                    "F00027",
                    "",
                    1,
                    189000 * 1,
                    Timestamp.valueOf(LocalDateTime.of(2025, 6, 4, 12, 0))
            );
            Order order27 = new Order(
                    "OR0406250001",
                    "T07",
                    "EMP004",
                    "EMP001",
                    LocalDateTime.of(2025, 6, 4, 12, 0),
                    LocalDateTime.of(2025, 6, 4, 12, 0),
                    OrderStatus.FINISHED,
                    "",
                    0f,
                    0,
                    189000 * 1,
                    Timestamp.valueOf(LocalDateTime.of(2025, 6, 4, 12, 0))
            );

// Order 28: 04/06/2025, Ravioli Gamberetti (F00028) x1
            OrderDetail od28 = new OrderDetail(
                    "OR0406250002",
                    "F00028",
                    "",
                    1,
                    179000 * 1,
                    Timestamp.valueOf(LocalDateTime.of(2025, 6, 4, 13, 0))
            );
            Order order28 = new Order(
                    "OR0406250002",
                    "T08",
                    "EMP004",
                    "EMP001",
                    LocalDateTime.of(2025, 6, 4, 13, 0),
                    LocalDateTime.of(2025, 6, 4, 13, 0),
                    OrderStatus.FINISHED,
                    "",
                    0f,
                    0,
                    179000 * 1,
                    Timestamp.valueOf(LocalDateTime.of(2025, 6, 4, 13, 0))
            );

// Day 5 (05/06/2025), two orders

// Order 29: 05/06/2025, Ravioli Salmone (F00029) x1
            OrderDetail od29 = new OrderDetail(
                    "OR0506250001",
                    "F00029",
                    "",
                    1,
                    189000 * 1,
                    Timestamp.valueOf(LocalDateTime.of(2025, 6, 5, 12, 0))
            );
            Order order29 = new Order(
                    "OR0506250001",
                    "T09",
                    "EMP004",
                    "EMP001",
                    LocalDateTime.of(2025, 6, 5, 12, 0),
                    LocalDateTime.of(2025, 6, 5, 12, 0),
                    OrderStatus.FINISHED,
                    "",
                    0f,
                    0,
                    189000 * 1,
                    Timestamp.valueOf(LocalDateTime.of(2025, 6, 5, 12, 0))
            );

// Order 30: 05/06/2025, Giant Pizza (42cm) (F00030) x1
            OrderDetail od30 = new OrderDetail(
                    "OR0506250002",
                    "F00030",
                    "",
                    1,
                    429000 * 1,
                    Timestamp.valueOf(LocalDateTime.of(2025, 6, 5, 13, 0))
            );
            Order order30 = new Order(
                    "OR0506250002",
                    "T10",
                    "EMP004",
                    "EMP001",
                    LocalDateTime.of(2025, 6, 5, 13, 0),
                    LocalDateTime.of(2025, 6, 5, 13, 0),
                    OrderStatus.FINISHED,
                    "",
                    0f,
                    0,
                    429000 * 1,
                    Timestamp.valueOf(LocalDateTime.of(2025, 6, 5, 13, 0))
            );

            //
            orderRepo.saveAll(List.of(
                    order1, order2, order3, order4, order5, order6, order7, order8, order9, order10,
                    order11, order12, order13, order14, order15, order16, order17, order18, order19, order20,
                    order21, order22, order23, order24, order25, order26, order27, order28, order29, order30
            ));

            orderDetailRepo.saveAll(List.of(
                    od1, od2, od3, od4, od5, od6, od7, od8, od9, od10,
                    od11, od12, od13, od14, od15, od16, od17, od18, od19, od20,
                    od21, od22, od23, od24, od25, od26, od27, od28, od29, od30
            ));
            tableReservationRepo.save(tableReservation);

        };
    }
}
