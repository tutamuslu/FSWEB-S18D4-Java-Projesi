package com.workintech.bankapi.service;

import com.workintech.bankapi.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<Customer> getAll();
    Optional<Customer> getById(int id);
    Customer addCustomer(Customer customer);
    Customer updateCustomer(int id, Customer customer);
    Customer deleteCustomer(int id);
}
