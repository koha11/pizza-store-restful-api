package io.github.koha11.pizza_store_pos.service;

import io.github.koha11.pizza_store_pos.entity.food.FoodType;
import io.github.koha11.pizza_store_pos.entity.mapper.AccountMapper;
import io.github.koha11.pizza_store_pos.entity.user.Account;
import io.github.koha11.pizza_store_pos.entity.user.AccountDTO;
import io.github.koha11.pizza_store_pos.entity.user.LoginRequest;
import io.github.koha11.pizza_store_pos.repository.AccountRepository;
import io.github.koha11.pizza_store_pos.util.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService extends GenericService<Account>{
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountMapper mapper;
    public AccountService(JpaRepository<Account, String> repo) {
        super(repo);
    }

    public AccountDTO getAccount(LoginRequest request) {
        Account account =  accountRepository.findByEmailAndPwd(request.getEmail(), request.getPwd());
        return mapper.accountToAccountDTO(account);
    };

}
