package io.github.koha11.pizza_store_pos.controller;

import io.github.koha11.pizza_store_pos.entity.user.Account;
import io.github.koha11.pizza_store_pos.entity.user.AccountDTO;
import io.github.koha11.pizza_store_pos.entity.user.AuthResponse;
import io.github.koha11.pizza_store_pos.entity.user.LoginRequest;
import io.github.koha11.pizza_store_pos.service.AccountService;
import io.github.koha11.pizza_store_pos.service.GenericService;
import io.github.koha11.pizza_store_pos.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AccountController extends GenericController<Account>{
    @Autowired
    private AccountService accountService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    public AccountController(GenericService<Account> genericService) {
        super(genericService);
    }

    @GetMapping("/accounts")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public List<AccountDTO> getAccounts() {
        return accountService.getAccounts();
    }
    @GetMapping("/accounts/{id}")
    public AccountDTO getAccount(@PathVariable String id) {
        return accountService.getAccountById(id);
    }

    @PostMapping("/accounts")
    public void addAccount(@RequestBody Account account) {
        accountService.create(account);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPwd())
        );

        if (authentication.isAuthenticated()) {
            return new AuthResponse(1,jwtService.generateToken(
                    request.getEmail()),
                    1000000 * 60 * 30
            );
        } else {
            return new AuthResponse(0,"", 0);
        }
    }

    @GetMapping("/get-info")
    public AccountDTO getInfo() {
        return accountService.getAccount();
    }

    @PutMapping("/accounts")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public Account updateAccount(@RequestBody Account account) {
        return accountService.updateAccount(account);
    }
}
