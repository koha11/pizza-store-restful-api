package io.github.koha11.pizza_store_pos.util;

import io.github.koha11.pizza_store_pos.entity.employee.Employee;
import io.github.koha11.pizza_store_pos.entity.food.Food;
import io.github.koha11.pizza_store_pos.entity.food.FoodType;
import io.github.koha11.pizza_store_pos.entity.order.BookedSeat;
import io.github.koha11.pizza_store_pos.entity.variant.Variant;

public class IdGenerator {
    static public <T> String generateId(T t, int length) {
        StringBuilder ch = new StringBuilder();

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

        return ch.toString();
    }
}
