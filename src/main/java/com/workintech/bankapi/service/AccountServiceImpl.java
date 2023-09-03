package com.workintech.bankapi.service;

import com.workintech.bankapi.dao.AccountRepository;
import com.workintech.bankapi.dao.CustomerRepository;
import com.workintech.bankapi.entity.Account;
import com.workintech.bankapi.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService{
    private AccountRepository accountRepository;
    private CustomerRepository customerRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository, CustomerRepository customerRepository){

        this.accountRepository = accountRepository;
        this.customerRepository = customerRepository;

    }

    @Override
    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    @Override
    public Optional<Account> getById(int id) {
        return accountRepository.findById(id);
    }

    @Override
    public Account addAccount(int customerId, Account account) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        account.setCustomerId(customer.get());
        return accountRepository.save(account);
    }

    @Override
    public Account updateAccount(int customerId, Account account) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        account.setCustomerId(customer.get());
        return accountRepository.save(account);
    }

    @Override
    public Account deleteAccount(int id) {
        Optional<Account> account = accountRepository.findById(id);
        if(account.get() != null){
            accountRepository.deleteById(id);
            return account.get();
        }
        return null;
    }
}
