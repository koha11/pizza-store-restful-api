package io.github.koha11.pizza_store_pos.repository;

import io.github.koha11.pizza_store_pos.entity.user.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
}
