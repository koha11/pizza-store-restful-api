package io.github.koha11.pizza_store_pos.controller;

import io.github.koha11.pizza_store_pos.entity.user.Account;
import io.github.koha11.pizza_store_pos.service.AccountService;
import io.github.koha11.pizza_store_pos.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController extends GenericController<Account>{
    @Autowired
    private AccountService accountService;

    public AccountController(GenericService<Account> genericService) {
        super(genericService);
    }
}
