package io.github.koha11.pizza_store_pos.entity.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO {
    private String empId;
    private String email;
    private Role role;
}
