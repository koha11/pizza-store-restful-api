package io.github.koha11.pizza_store_pos.service;

import io.github.koha11.pizza_store_pos.entity.mapper.AccountMapper;
import io.github.koha11.pizza_store_pos.entity.user.Account;
import io.github.koha11.pizza_store_pos.entity.user.AccountDTO;
import io.github.koha11.pizza_store_pos.entity.user.LoginRequest;
import io.github.koha11.pizza_store_pos.entity.user.Role;
import io.github.koha11.pizza_store_pos.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService extends GenericService<Account> implements UserDetailsService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private AccountMapper mapper;

    public AccountService(JpaRepository<Account, String> repo) {
        super(repo);
    }

    public AccountService() {
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Account> userDetail = accountRepository.findByEmail(username);

        // Converting UserInfo to UserDetails
        return userDetail.map(AccountDTO::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
    }

    public AccountDTO getAccount(LoginRequest request) {
        Account account =  accountRepository.findByEmailAndPwd(request.getEmail(), request.getPwd());
        return mapper.accountToAccountDTO(account);
    };

    public AccountDTO getAccount() {
        AccountDTO account = (AccountDTO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        account.setPwd("");

        return account;
    };

    public List<AccountDTO> getAccounts() {
        List<Account> accounts = accountRepository.findAll().stream().filter(account -> !account.getRole().equals(Role.ROLE_ADMIN)).toList();
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
