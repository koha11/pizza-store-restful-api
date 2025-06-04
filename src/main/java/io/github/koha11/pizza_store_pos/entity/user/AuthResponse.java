package io.github.koha11.pizza_store_pos.entity.user;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponse {
    private int status;
    private String accessToken;
    private int expiredIn;
}
