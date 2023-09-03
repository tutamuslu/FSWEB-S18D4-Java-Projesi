package com.workintech.bankapi.service;

import com.workintech.bankapi.entity.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    List<Account> getAll();
    Optional<Account> getById(int id);
    Account addAddress(Account account);
    Account updateAddress(int id, Account account);
    Account deleteAddress(int id);
}
