package com.workintech.bankapi.service;

import com.workintech.bankapi.dao.AddressRepository;
import com.workintech.bankapi.dao.CustomerRepository;
import com.workintech.bankapi.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{
    private CustomerRepository customerRepository;
    private AddressRepository addressRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, AddressRepository addressRepository){

        this.customerRepository = customerRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> getById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(int id, Customer customer) {
        customer.setId(id);
        return customerRepository.save(customer);
    }

    @Override
    public Customer deleteCustomer(int id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if(customer.get() != null){
            customerRepository.deleteById(id);
            addressRepository.deleteById(customer.get().getAddressId().getId());
            return customer.get();
        }
        return null;
    }
}
