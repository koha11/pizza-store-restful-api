package io.github.koha11.pizza_store_pos.service;

import io.github.koha11.pizza_store_pos.entity.employee.Employee;
import io.github.koha11.pizza_store_pos.entity.food.FoodType;
import io.github.koha11.pizza_store_pos.entity.mapper.AccountMapper;
import io.github.koha11.pizza_store_pos.entity.user.Account;
import io.github.koha11.pizza_store_pos.entity.user.AccountDTO;
import io.github.koha11.pizza_store_pos.entity.user.LoginRequest;
import io.github.koha11.pizza_store_pos.entity.user.Role;
import io.github.koha11.pizza_store_pos.repository.AccountRepository;
import io.github.koha11.pizza_store_pos.util.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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

    public AccountDTO getAccountById(String id) {
        Account account =  accountRepository.findById(id).orElse(null);
        return mapper.accountToAccountDTO(account);
    };

    public List<AccountDTO> getAccounts() {
        List<Account> accounts = accountRepository.findAll().stream().filter(account -> !account.getRole().equals(Role.ADMIN)).toList();
        return accounts.stream().map(account -> mapper.accountToAccountDTO(account)).toList();
    }

    @Override
    public void create(Account ac) {
        ac.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
        repo.save(ac);
    }

    public Account updateAccount(Account ac) {
        Account acExist = getOne(ac.getEmpId());
        if(acExist == null) return null;
        ac.setLastAccess(acExist.getLastAccess());
        ac.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
        return update(ac.getEmpId(), ac);
    }


}
