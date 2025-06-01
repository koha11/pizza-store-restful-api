package io.github.koha11.pizza_store_pos.controller;

import io.github.koha11.pizza_store_pos.entity.user.Account;
import io.github.koha11.pizza_store_pos.entity.user.AccountDTO;
import io.github.koha11.pizza_store_pos.entity.user.LoginRequest;
import io.github.koha11.pizza_store_pos.service.AccountService;
import io.github.koha11.pizza_store_pos.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AccountController extends GenericController<Account>{
    @Autowired
    private AccountService accountService;

    public AccountController(GenericService<Account> genericService) {
        super(genericService);
    }

    @GetMapping("/accounts")
    public List<AccountDTO> getAccounts() {
        return accountService.getAccounts();
    }

    @PostMapping("/accounts")
    public void addAccount(@RequestBody Account account) {
        accountService.create(account);
    }
    @PostMapping("/login")
    public AccountDTO login(@RequestBody LoginRequest request) {
        return accountService.getAccount(request);
    }
}
