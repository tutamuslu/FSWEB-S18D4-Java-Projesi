package com.workintech.bankapi.service;

import com.workintech.bankapi.entity.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    List<Account> getAll();
    Optional<Account> getById(int id);
    Account addAccount(int customerId, Account account);
    Account updateAccount(int customerId, Account account);
    Account deleteAccount(int id);
}
