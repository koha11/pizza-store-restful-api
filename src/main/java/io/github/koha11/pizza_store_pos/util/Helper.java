package io.github.koha11.pizza_store_pos.util;

import io.github.koha11.pizza_store_pos.entity.employee.Employee;
import io.github.koha11.pizza_store_pos.entity.food.Food;
import io.github.koha11.pizza_store_pos.entity.food.FoodType;
import io.github.koha11.pizza_store_pos.entity.order.BookedSeat;
import io.github.koha11.pizza_store_pos.entity.order.Order;
import io.github.koha11.pizza_store_pos.entity.variant.Variant;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class Helper {
    static public <T> String generateId(T t, int length) {
        StringBuilder ch = new StringBuilder();

        if(t == Order.class)
        {
            ch.append("OR");

            LocalDate today = LocalDate.now();

            String day = today.getDayOfMonth() >= 10 ? String.valueOf(today.getDayOfMonth()) : "0" + today.getDayOfMonth();

            String month = today.getMonthValue() >= 10 ? String.valueOf(today.getMonthValue()) : "0" + today.getMonthValue();

            String year = String.valueOf(today.getYear()).substring(2);

            ch.append(day);
            ch.append(month);
            ch.append(year);

            var sizeText = String.valueOf(length);

            ch.append("0".repeat(4 - sizeText.length()));
            ch.append(length + 1);
        }
        else
        {
            if(t == Food.class)
                ch.append("F");

            if(t == FoodType.class)
                ch.append("FT");

            if(t == Employee.class)
                ch.append("EMP");

            if(t == BookedSeat.class)
                ch.append("BS");

            if(t == Variant.class)
                ch.append("V");

            var sizeText = String.valueOf(length);

            ch.append("0".repeat(6 - ch.length() - sizeText.length()));
            ch.append(length+1);
        }

        return ch.toString();
    }
}
