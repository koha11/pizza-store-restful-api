package io.github.koha11.pizza_store_pos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .anyRequest().permitAll() // Cho phép tất cả request mà không cần đăng nhập
                )
                .csrf(AbstractHttpConfigurer::disable) // Tắt CSRF nếu cần
                .formLogin(AbstractHttpConfigurer::disable);
        return http.build();
    }
}