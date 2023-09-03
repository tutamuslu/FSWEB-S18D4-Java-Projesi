package com.workintech.bankapi.controller;

import com.workintech.bankapi.entity.Account;
import com.workintech.bankapi.entity.Customer;
import com.workintech.bankapi.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }

    @GetMapping("/")
    public List<Account> getAll(){
        return accountService.getAll();
    }

    @GetMapping("/{id}")
    public Account getById(@PathVariable int id){
        Optional<Account> account = accountService.getById(id);
        if(account.get() == null){
            return null;
        }
        return account.get();
    }

    @PostMapping("/{customerId}")
    public Account save(@PathVariable int customerId, @RequestBody Account account){
        return accountService.addAccount(customerId, account);
    }

    @PutMapping("/{customerId}")
    public Account update(@PathVariable int customerId, @RequestBody Account account){
        return accountService.updateAccount(customerId, account);
    }

    @DeleteMapping("/{id}")
    public Account delete(@PathVariable int id){
        return accountService.deleteAccount(id);
    }
}
