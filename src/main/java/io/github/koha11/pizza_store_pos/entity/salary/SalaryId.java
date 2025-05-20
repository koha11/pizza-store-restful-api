package io.github.koha11.pizza_store_pos.entity.salary;

import java.io.Serializable;
import java.time.Month;

public class SalaryId implements Serializable {
    private String empId;
    private Month month;
    private int year;
}
