package io.github.koha11.pizza_store_pos.config;

import io.github.koha11.pizza_store_pos.entity.food.Food;
import io.github.koha11.pizza_store_pos.entity.food.FoodType;
import io.github.koha11.pizza_store_pos.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class FoodConfig {
    @Bean
    CommandLineRunner commandLineRunnerForFood(FoodRepository foodRepo, FoodTypeRepository foodTypeRepo) {
        return args -> {
//            FoodType pizza = new FoodType("FT0001", "Pizza", "https://ilmio.vn/uploads/fnb-menu/pizza/giant-pizza-size42cm.jpg", Timestamp.valueOf(LocalDateTime.now()));
//
//            FoodType desert = new FoodType("FT0002", "Desert", "https://ilmio.vn/uploads/fnb-menu/pizza/giant-pizza-size42cm.jpg", Timestamp.valueOf(LocalDateTime.now()));

//            Food peperoni = new Food("F00001", "FT0001", "Peperoni", "https://ilmio.vn/uploads/fnb-menu/pizza/pizza-pepperoni.jpg","Italian sausages, mozzarella.", 135000, Timestamp.valueOf(LocalDateTime.now()));
//
//            Food margherita = new Food("F00002", "FT0002", "Margherita", "https://ilmio.vn/uploads/fnb-menu/pizza/pizza-margherita.jpg", "A classic pizza originating in Naples Italy: Tomato sauce and mozzarella.", 98000, Timestamp.valueOf(LocalDateTime.now()));

            FoodType appetizers = new FoodType(
                    "FT0001",
                    "APPETIZERS",
                    null,
                    Timestamp.valueOf(LocalDateTime.now())
            );

            FoodType spaghetti = new FoodType(
                    "FT0002",
                    "SPAGHETTI",
                    null,
                    Timestamp.valueOf(LocalDateTime.now())
            );

            FoodType homeMadePasta = new FoodType(
                    "FT0003",
                    "HOME MADE PASTA",
                    null,
                    Timestamp.valueOf(LocalDateTime.now())
            );

            FoodType pizza = new FoodType(
                    "FT0004",
                    "PIZZA",
                    null,
                    Timestamp.valueOf(LocalDateTime.now())
            );

            FoodType mainCourse = new FoodType(
                    "FT0005",
                    "MAIN COURSE",
                    null,
                    Timestamp.valueOf(LocalDateTime.now())
            );

            FoodType dessert = new FoodType(
                    "FT0006",
                    "DESSERT",
                    null,
                    Timestamp.valueOf(LocalDateTime.now())
            );

            Food pumpkinSoup = new Food(
                    "F00001",
                    "FT0001",
                    "Pumpkin Soup",
                    "https://ilmio.vn/uploads/fnb-menu/appetizers/creamy-pumpkin-soup.jpg",
                    "TASTY CREAM PUMPKIN SOUP.",
                    49000,
                    Timestamp.valueOf(LocalDateTime.now())
            );

            Food seafoodSoup = new Food(
                    "F00002",
                    "FT0001",
                    "Seafood Soup",
                    "https://ilmio.vn/uploads/fnb-menu/appetizers/seafood-soup.jpg",
                    "Seafood soup in spicy tomato sauce with shrimps, squid, and clams.",
                    115000,
                    Timestamp.valueOf(LocalDateTime.now())
            );

            Food sauteDiVongole = new Food(
                    "F00003",
                    "FT0001",
                    "Saute Di Vongole",
                    "https://ilmio.vn/uploads/fnb-menu/appetizers/saute-di-vongole.jpg",
                    "Steamed fresh clams with olive oil, garlic, chilli and parsley leaves.",
                    99000,
                    Timestamp.valueOf(LocalDateTime.now())
            );

            Food mistiBruschette = new Food(
                    "F00004",
                    "FT0001",
                    "Misti Bruschette",
                    "https://ilmio.vn/uploads/fnb-menu/appetizers/misti-bruschette.jpg",
                    "3 kind of different bruschetta.",
                    98000,
                    Timestamp.valueOf(LocalDateTime.now())
            );

            Food garlicBread = new Food(
                    "F00005",
                    "FT0001",
                    "Garlic Bread",
                    "https://ilmio.vn/uploads/fnb-menu/appetizers/garlic-bread.jpg",
                    "No description.",
                    38000,
                    Timestamp.valueOf(LocalDateTime.now())
            );

            Food insalataSiciliana = new Food(
                    "F00006",
                    "FT0001",
                    "Insalata Siciliana",
                    "https://ilmio.vn/uploads/fnb-menu/appetizers/insalata-siciliana.jpg",
                    "Mix Salad with tuna in oil.",
                    85000,
                    Timestamp.valueOf(LocalDateTime.now())
            );

            Food shrimpSalad = new Food(
                    "F00007",
                    "FT0001",
                    "Shrimp Salad",
                    "https://ilmio.vn/uploads/fnb-menu/appetizers/shrimp-salad.jpg",
                    "No description.",
                    145000,
                    Timestamp.valueOf(LocalDateTime.now())
            );

            Food beefCarpaccio = new Food(
                    "F00008",
                    "FT0001",
                    "Beef Carpaccio",
                    "https://ilmio.vn/uploads/fnb-menu/appetizers/beef-carpaccio.jpg",
                    "Beed carpaccio with rucola and parmesan, dressed with olive oil vinaigrette.",
                    145000,
                    Timestamp.valueOf(LocalDateTime.now())
            );

// Spaghetti (FT0002)
            Food spaghettiBolognese = new Food(
                    "F00009",
                    "FT0002",
                    "Spaghetti Bolognese",
                    "https://ilmio.vn/uploads/fnb-menu/spaghetti/spaghetti-bolognese.jpg",
                    "Traditional meat ragu sauce.",
                    127000,
                    Timestamp.valueOf(LocalDateTime.now())
            );

            Food spaghettiPomodoro = new Food(
                    "F00010",
                    "FT0002",
                    "Spaghetti Pomodoro",
                    "https://ilmio.vn/uploads/fnb-menu/spaghetti/spaghetti-pomodoro.jpg",
                    "A simple tomato sauce with fresh basil.",
                    98000,
                    Timestamp.valueOf(LocalDateTime.now())
            );

            Food spaghettiPesto = new Food(
                    "F00011",
                    "FT0002",
                    "Spaghetti Pesto",
                    "https://ilmio.vn/uploads/fnb-menu/spaghetti/spaghetti-pesto.jpg",
                    "Basil sauce, cheese and walnuts.",
                    169000,
                    Timestamp.valueOf(LocalDateTime.now())
            );

            Food spaghettiAllacciuga = new Food(
                    "F00012",
                    "FT0002",
                    "Spaghetti All'acciuga",
                    "https://ilmio.vn/uploads/fnb-menu/spaghetti/spaghetti-allacciuga.jpg",
                    "Spaghetti with olive oil, anchovies, garlic and chilli.",
                    125000,
                    Timestamp.valueOf(LocalDateTime.now())
            );

            Food spaghettiCarbonara = new Food(
                    "F00013",
                    "FT0002",
                    "Spaghetti Carbonara",
                    "https://ilmio.vn/uploads/fnb-menu/spaghetti/spaghetti-carbonara.jpg",
                    "BACON, EGGS, CREAM.",
                    137000,
                    Timestamp.valueOf(LocalDateTime.now())
            );

            Food spaghettiVongole = new Food(
                    "F00014",
                    "FT0002",
                    "Spaghetti Vongole",
                    "https://ilmio.vn/uploads/fnb-menu/spaghetti/spaghetti-vongole.jpg",
                    "STEAMED CLAMS WITH OLIVE OLIO, GARLIC, CHILI AMID FRESH PARLEYS.",
                    145000,
                    Timestamp.valueOf(LocalDateTime.now())
            );

            Food spaghettiMarinara = new Food(
                    "F00015",
                    "FT0002",
                    "Spaghetti Marinara",
                    "https://ilmio.vn/uploads/fnb-menu/spaghetti/spaghetti-marinara.jpg",
                    "MIXED SEAFOOD, DICED TOMATOES, GARLIC, CHILLI AND FRESH PARLEY.",
                    179000,
                    Timestamp.valueOf(LocalDateTime.now())
            );

            Food penneAlForno = new Food(
                    "F00016",
                    "FT0002",
                    "Penne Al Forno",
                    "https://ilmio.vn/uploads/fnb-menu/spaghetti/penne-al-forno.jpg",
                    "TRADITIONAL MINCED BEEF RAGU SAUCE, BAKED WITH CHEESE, TOPPED WITH CREAM SAUCE.",
                    165000,
                    Timestamp.valueOf(LocalDateTime.now())
            );

            Food penneArrabbiata = new Food(
                    "F00017",
                    "FT0002",
                    "Penne Arrabbiata",
                    "https://ilmio.vn/uploads/fnb-menu/spaghetti/penne-arrabbiata.jpg",
                    "Short pasta in a spicy, tomato sauce with chili and garlic.",
                    98000,
                    Timestamp.valueOf(LocalDateTime.now())
            );

            Food pennePuttanesca = new Food(
                    "F00018",
                    "FT0002",
                    "Penne Puttanesca",
                    "https://ilmio.vn/uploads/fnb-menu/spaghetti/penne-puttanesca.jpg",
                    "No description.",
                    137000,
                    Timestamp.valueOf(LocalDateTime.now())
            );

            Food penneAlfredo = new Food(
                    "F00019",
                    "FT0002",
                    "Penne Alfredo",
                    "https://ilmio.vn/uploads/fnb-menu/spaghetti/penne-alfredo.jpg",
                    "CREAMY CHICKEN SAUCE, BROCCOLI AND CHEESE.",
                    137000,
                    Timestamp.valueOf(LocalDateTime.now())
            );

            Food penneBoscaiola = new Food(
                    "F00020",
                    "FT0002",
                    "Penne Boscaiola",
                    "https://ilmio.vn/uploads/fnb-menu/spaghetti/penne-boscaiola.jpg",
                    "Short pasta cooked with ham, mushrooms and creamy sauce.",
                    169000,
                    Timestamp.valueOf(LocalDateTime.now())
            );

            Food penneAlSalmone = new Food(
                    "F00021",
                    "FT0002",
                    "Penne Al Salmone",
                    "https://ilmio.vn/uploads/fnb-menu/spaghetti/penne-al-salmone.jpg",
                    "CREAMY SAUCE WITH SMOKED SALMON AND ONIONS.",
                    179000,
                    Timestamp.valueOf(LocalDateTime.now())
            );

            Food penne4Formaggi = new Food(
                    "F00022",
                    "FT0002",
                    "Penne 4 Formaggi",
                    "https://ilmio.vn/uploads/fnb-menu/spaghetti/penne-4-formaggi.jpg",
                    "A medley of 4 different cheeses: Gorgonzola, Mozzarella, Parmesan, and Gouda.",
                    189000,
                    Timestamp.valueOf(LocalDateTime.now())
            );

// Home Made Pasta (FT0003)
            Food lasagna = new Food(
                    "F00023",
                    "FT0003",
                    "Lasagna",
                    "https://ilmio.vn/uploads/fnb-menu/homemade-pasta/lasagna.jpg",
                    "Italian lasagne with bolognese ragu sauce, parmesan cheese & white sauce,",
                    169000,
                    Timestamp.valueOf(LocalDateTime.now())
            );

            Food fettuccineContadina = new Food(
                    "F00024",
                    "FT0003",
                    "Fettuccine Contadina",
                    "https://ilmio.vn/uploads/fnb-menu/homemade-pasta/fettuccine-contadina.jpg",
                    "Home-made flat pasta with bacon, mushrooms, and onions.",
                    169000,
                    Timestamp.valueOf(LocalDateTime.now())
            );

            Food fettuccineSalmone = new Food(
                    "F00025",
                    "FT0003",
                    "Fettuccine Salmone",
                    "https://ilmio.vn/uploads/fnb-menu/homemade-pasta/fettuccine-salmone.jpg",
                    "Homemade fettuccine with cream sauce, onions, and smoked salmon.",
                    179000,
                    Timestamp.valueOf(LocalDateTime.now())
            );

            Food gnocchiAlPomodoro = new Food(
                    "F00026",
                    "FT0003",
                    "Gnocchi Al Pomodoro",
                    "https://ilmio.vn/uploads/fnb-menu/homemade-pasta/gnocchi-al-pomodoro.jpg",
                    "Home-made potato dumplings in tomato sauce.",
                    169000,
                    Timestamp.valueOf(LocalDateTime.now())
            );

            Food gnocchiGorgonzola = new Food(
                    "F00027",
                    "FT0003",
                    "Gnocchi Gorgonzola",
                    "https://ilmio.vn/uploads/fnb-menu/homemade-pasta/gnocchi-gorgonzola.jpg",
                    "Potatoes dumpings with gorgonzola cheese.",
                    189000,
                    Timestamp.valueOf(LocalDateTime.now())
            );

            Food ravioliGamberetti = new Food(
                    "F00028",
                    "FT0003",
                    "Ravioli Gamberetti",
                    "https://ilmio.vn/uploads/fnb-menu/homemade-pasta/ravioli-gamberetti.jpg",
                    "Ravioli stuffed with shrimps and cream cheese.",
                    179000,
                    Timestamp.valueOf(LocalDateTime.now())
            );

            Food ravioliSalmone = new Food(
                    "F00029",
                    "FT0003",
                    "Ravioli Salmone",
                    "https://ilmio.vn/uploads/fnb-menu/homemade-pasta/ravioli-salmone.jpg",
                    "Ravioli stuffed with salmone and potatoes.",
                    189000,
                    Timestamp.valueOf(LocalDateTime.now())
            );

// Pizza (FT0004)
            Food giantPizza42cm = new Food(
                    "F00030",
                    "FT0004",
                    "Giant Pizza (42cm)",
                    "https://ilmio.vn/uploads/fnb-menu/pizza/giant-pizza-42cm.jpg",
                    "07 ingredients: Peperoni, chicken, French fried, seafood, traditional beef ragu, bacon, fresh Italian sausages, spinach with creamy sauce.",
                    429000,
                    Timestamp.valueOf(LocalDateTime.now())
            );

            Food margheritaPizza = new Food(
                    "F00031",
                    "FT0004",
                    "Margherita",
                    "https://ilmio.vn/uploads/fnb-menu/pizza/margherita.jpg",
                    "A classic pizza originating in Naples, Italy: Tomato sauce and mozzarella.",
                    98000,
                    Timestamp.valueOf(LocalDateTime.now())
            );

            Food spinakopita = new Food(
                    "F00032",
                    "FT0004",
                    "Spinakopita",
                    "https://ilmio.vn/uploads/fnb-menu/pizza/spinakopita.jpg",
                    "Spinach and mozzarella.",
                    129000,
                    Timestamp.valueOf(LocalDateTime.now())
            );

            Food fourFormaggi = new Food(
                    "F00033",
                    "FT0004",
                    "4 Formaggi",
                    "https://ilmio.vn/uploads/fnb-menu/pizza/4-formaggi.jpg",
                    "Mozzarella, gorgonzola, camembert, gouda; served with pure honey.",
                    179000,
                    Timestamp.valueOf(LocalDateTime.now())
            );

            Food funghi = new Food(
                    "F00034",
                    "FT0004",
                    "Funghi",
                    "https://ilmio.vn/uploads/fnb-menu/pizza/funghi.jpg",
                    "Mushrooms, ham and mozzarella.",
                    125000,
                    Timestamp.valueOf(LocalDateTime.now())
            );

            Food tropicale = new Food(
                    "F00035",
                    "FT0004",
                    "Tropicale",
                    "https://ilmio.vn/uploads/fnb-menu/pizza/tropicale.jpg",
                    "Pineapple, mozzarella, ham and tomato sauce.",
                    125000,
                    Timestamp.valueOf(LocalDateTime.now())
            );

            Food tonnoCipolla = new Food(
                    "F00036",
                    "FT0004",
                    "Tonno Cipolla",
                    "https://ilmio.vn/uploads/fnb-menu/pizza/tonno-cipolla.jpg",
                    "Tomoto sauce, mozzarella, canned tuna in oil and fresh onion.",
                    125000,
                    Timestamp.valueOf(LocalDateTime.now())
            );

            Food romana = new Food(
                    "F00037",
                    "FT0004",
                    "Romana",
                    "https://ilmio.vn/uploads/fnb-menu/pizza/romana.jpg",
                    "Smoked bacon, mozzarella.",
                    125000,
                    Timestamp.valueOf(LocalDateTime.now())
            );

            Food peperoniPizza = new Food(
                    "F00038",
                    "FT0004",
                    "Peperoni",
                    "https://ilmio.vn/uploads/fnb-menu/pizza/peperoni.jpg",
                    "Italian sausages, mozzarella.",
                    135000,
                    Timestamp.valueOf(LocalDateTime.now())
            );

            Food chickenBBQ = new Food(
                    "F00039",
                    "FT0004",
                    "Chicken BBQ",
                    "https://ilmio.vn/uploads/fnb-menu/pizza/chicken-bbq.jpg",
                    "BBQ chicken, onion, mozzarella.",
                    139000,
                    Timestamp.valueOf(LocalDateTime.now())
            );

            Food carbonaraPizza = new Food(
                    "F00040",
                    "FT0004",
                    "Carbonara",
                    "https://ilmio.vn/uploads/fnb-menu/pizza/carbonara.jpg",
                    "Smoked bacon, egg, creamy sauces and mozzarella.",
                    135000,
                    Timestamp.valueOf(LocalDateTime.now())
            );

            Food pazza = new Food(
                    "F00041",
                    "FT0004",
                    "Pazza",
                    "https://ilmio.vn/uploads/fnb-menu/pizza/pazza.jpg",
                    "Smoked bacon, ham, mushrooms, corn, olives.",
                    139000,
                    Timestamp.valueOf(LocalDateTime.now())
            );

            Food napoli = new Food(
                    "F00042",
                    "FT0004",
                    "Napoli",
                    "https://ilmio.vn/uploads/fnb-menu/pizza/napoli.jpg",
                    "Olives, anchovies in oil and mozzarella.",
                    135000,
                    Timestamp.valueOf(LocalDateTime.now())
            );

            Food salsiccia = new Food(
                    "F00043",
                    "FT0004",
                    "Salsiccia",
                    "https://ilmio.vn/uploads/fnb-menu/pizza/salsiccia.jpg",
                    "Fresh Italian sausage, bell pepper, spring onion.",
                    149000,
                    Timestamp.valueOf(LocalDateTime.now())
            );

            Food bolognesePizza = new Food(
                    "F00044",
                    "FT0004",
                    "Bolognese",
                    "https://ilmio.vn/uploads/fnb-menu/pizza/bolognese.jpg",
                    "Mozzarella, traditional beef ragu sauce.",
                    135000,
                    Timestamp.valueOf(LocalDateTime.now())
            );

            Food salmonePizza = new Food(
                    "F00045",
                    "FT0004",
                    "Salmone",
                    "https://ilmio.vn/uploads/fnb-menu/pizza/salmone.jpg",
                    "Salmon, bell pepper, broccoli, milk cream, mozzarella.",
                    179000,
                    Timestamp.valueOf(LocalDateTime.now())
            );

            Food seafoodPizza = new Food(
                    "F00046",
                    "FT0004",
                    "Seafood",
                    "https://ilmio.vn/uploads/fnb-menu/pizza/seafood.jpg",
                    "Shrimp, quid, mozzarella.",
                    145000,
                    Timestamp.valueOf(LocalDateTime.now())
            );

            Food parmaHam = new Food(
                    "F00047",
                    "FT0004",
                    "Parma Ham",
                    "https://ilmio.vn/uploads/fnb-menu/pizza/parma-ham.jpg",
                    "Mozzarella, tomato sauce, Parma ham, Parmesan cheese and rucola.",
                    179000,
                    Timestamp.valueOf(LocalDateTime.now())
            );

            Food ilCalzone = new Food(
                    "F00048",
                    "FT0004",
                    "Il Calzone",
                    "https://ilmio.vn/uploads/fnb-menu/pizza/il-calzone.jpg",
                    "Special pizza with cream cheese, Spicy Italia sausage, mushrooms and olives.",
                    189000,
                    Timestamp.valueOf(LocalDateTime.now())
            );

// Main Courses (FT0005)
            Food grilledRibEyeSteak = new Food(
                    "F00049",
                    "FT0005",
                    "Grilled Rib-Eye Steak",
                    "https://ilmio.vn/uploads/fnb-menu/main-courses/grilled-rib-eye-steak.jpg",
                    "Grilled New Zealand rib-eye beef, served with fries, salads, mushroom sauce or pepper sauce.",
                    389000,
                    Timestamp.valueOf(LocalDateTime.now())
            );

            Food grilledItalianSausages = new Food(
                    "F00050",
                    "FT0005",
                    "Grilled Italian Sausages",
                    "https://ilmio.vn/uploads/fnb-menu/main-courses/grilled-italian-sausages.jpg",
                    "Grilled Italian sausage, served with mashed potatoes and salad.",
                    199000,
                    Timestamp.valueOf(LocalDateTime.now())
            );

            Food bbqPorkRibs = new Food(
                    "F00051",
                    "FT0005",
                    "BBQ Pork Ribs",
                    "https://ilmio.vn/uploads/fnb-menu/main-courses/bbq-pork-ribs.jpg",
                    "BBQ pork ribs served with French fries and salad.",
                    199000,
                    Timestamp.valueOf(LocalDateTime.now())
            );

            Food chickenParmesan = new Food(
                    "F00052",
                    "FT0005",
                    "Chicken Parmesan",
                    "https://ilmio.vn/uploads/fnb-menu/main-courses/chicken-parmesan.jpg",
                    "Breaded chicken breast topped with tomato sauce, mozzarella and parmesan served with fries.",
                    145000,
                    Timestamp.valueOf(LocalDateTime.now())
            );

            Food frittoMisto = new Food(
                    "F00053",
                    "FT0005",
                    "Fritto Misto",
                    "https://ilmio.vn/uploads/fnb-menu/main-courses/fritto-misto.jpg",
                    "Italian style deep fried shrimps and calamari, served with French fries.",
                    155000,
                    Timestamp.valueOf(LocalDateTime.now())
            );

// Dessert (FT0006)
            Food pannaCotta = new Food(
                    "F00054",
                    "FT0006",
                    "Panna Cotta",
                    "https://ilmio.vn/uploads/fnb-menu/dessert/panna-cotta.jpg",
                    "Home made from fresh milk cream with passion fruit.",
                    59000,
                    Timestamp.valueOf(LocalDateTime.now())
            );

            Food semifreddo = new Food(
                    "F00055",
                    "FT0006",
                    "Semifreddo",
                    "https://ilmio.vn/uploads/fnb-menu/dessert/semifreddo.jpg",
                    "Home-made parfait (chilled cream) with almonds, honey and a touch of amaretto served with hot chocolate sauce.",
                    79000,
                    Timestamp.valueOf(LocalDateTime.now())
            );

            Food tiramisu = new Food(
                    "F00056",
                    "FT0006",
                    "Tiramisu",
                    "https://ilmio.vn/uploads/fnb-menu/dessert/tiramisu.jpg",
                    "A must, the real one with mascarpone, biscuits, espresso coffee and a drop of liquor.",
                    89000,
                    Timestamp.valueOf(LocalDateTime.now())
            );

            Food chocolateMousse = new Food(
                    "F00057",
                    "FT0006",
                    "Chocolate Mousse",
                    "https://ilmio.vn/uploads/fnb-menu/dessert/chocolate-mousse.jpg",
                    "Special Italian chocolate with fresh cream.",
                    59000,
                    Timestamp.valueOf(LocalDateTime.now())
            );

            Food affogatoEspresso = new Food(
                    "F00058",
                    "FT0006",
                    "Affogato Espresso",
                    "https://ilmio.vn/uploads/fnb-menu/dessert/affogato-espresso.png",
                    "Vanilla ice cream with espresso.",
                    89000,
                    Timestamp.valueOf(LocalDateTime.now())
            );

            foodTypeRepo.saveAll(List.of(
                    appetizers,
                    spaghetti,
                    homeMadePasta,
                    pizza,
                    mainCourse,
                    dessert
            ));

            foodRepo.saveAll(List.of(
                    pumpkinSoup,
                    seafoodSoup,
                    sauteDiVongole,
                    mistiBruschette,
                    garlicBread,
                    insalataSiciliana,
                    shrimpSalad,
                    beefCarpaccio,
                    spaghettiBolognese,
                    spaghettiPomodoro,
                    spaghettiPesto,
                    spaghettiAllacciuga,
                    spaghettiCarbonara,
                    spaghettiVongole,
                    spaghettiMarinara,
                    penneAlForno,
                    penneArrabbiata,
                    pennePuttanesca,
                    penneAlfredo,
                    penneBoscaiola,
                    penneAlSalmone,
                    penne4Formaggi,
                    lasagna,
                    fettuccineContadina,
                    fettuccineSalmone,
                    gnocchiAlPomodoro,
                    gnocchiGorgonzola,
                    ravioliGamberetti,
                    ravioliSalmone,
                    giantPizza42cm,
                    margheritaPizza,
                    spinakopita,
                    fourFormaggi,
                    funghi,
                    tropicale,
                    tonnoCipolla,
                    romana,
                    peperoniPizza,
                    chickenBBQ,
                    carbonaraPizza,
                    pazza,
                    napoli,
                    salsiccia,
                    bolognesePizza,
                    salmonePizza,
                    seafoodPizza,
                    parmaHam,
                    ilCalzone,
                    grilledRibEyeSteak,
                    grilledItalianSausages,
                    bbqPorkRibs,
                    chickenParmesan,
                    frittoMisto,
                    pannaCotta,
                    semifreddo,
                    tiramisu,
                    chocolateMousse,
                    affogatoEspresso
            ));
        };
    }
}
