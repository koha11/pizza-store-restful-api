package io.github.koha11.pizza_store_pos.util;

import io.github.koha11.pizza_store_pos.entity.employee.Employee;
import io.github.koha11.pizza_store_pos.entity.food.Food;
import io.github.koha11.pizza_store_pos.entity.food.FoodType;
import io.github.koha11.pizza_store_pos.entity.store_table.StoreTable;
import io.github.koha11.pizza_store_pos.entity.table_reservation.TableReservation;
import io.github.koha11.pizza_store_pos.entity.order.Order;
import io.github.koha11.pizza_store_pos.entity.violation.Violation;
import io.github.koha11.pizza_store_pos.entity.violation.ViolationRecord;

import java.time.LocalDate;

public class Helper {
    // To get a string like "ddmmyy"
    static public String getDateString(LocalDate localdate) {
        StringBuilder sb = new StringBuilder();

        String day = localdate.getDayOfMonth() >= 10 ? String.valueOf(localdate.getDayOfMonth()) : "0" + localdate.getDayOfMonth();

        String month = localdate.getMonthValue() >= 10 ? String.valueOf(localdate.getMonthValue()) : "0" + localdate.getMonthValue();

        String year = String.valueOf(localdate.getYear()).substring(2);

        sb.append(day);
        sb.append(month);
        sb.append(year);

        return sb.toString();
    }

        static public <T> String generateId(T t, int length) {
        StringBuilder ch = new StringBuilder();

        if(t == Order.class)
        {
            ch.append("OR");

            ch.append(getDateString(LocalDate.now()));

            var sizeText = String.valueOf(length);

            ch.append("0".repeat(4 - sizeText.length()));
            ch.append(length + 1);
        }
        else if(t == StoreTable.class) {
            ch.append("T");
            var sizeText = String.valueOf(length);

            ch.append("0".repeat(2 - sizeText.length()));
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

            if(t == TableReservation.class)
                ch.append("TR");

            if(t == ViolationRecord.class)
                ch.append("VR");

            if(t == Violation.class)
                ch.append("V");

            var sizeText = String.valueOf(length);

            ch.append("0".repeat(6 - ch.length() - sizeText.length()));
            ch.append(length+1);
        }

        return ch.toString();
    }
}
