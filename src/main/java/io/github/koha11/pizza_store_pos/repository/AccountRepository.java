package io.github.koha11.pizza_store_pos.repository;

import io.github.koha11.pizza_store_pos.entity.user.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, String> {
    @Query("select ac from Account ac where ac.email = :email and ac.pwd = :pwd")
    Account findByEmailAndPwd(String email, String pwd);

    @Query("select ac from Account ac where ac.email = :email")
    Optional<Account> findByEmail(String email);
}
