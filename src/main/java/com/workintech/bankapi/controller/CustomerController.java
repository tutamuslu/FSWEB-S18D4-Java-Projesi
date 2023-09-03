package com.workintech.bankapi.controller;

import com.workintech.bankapi.entity.Address;
import com.workintech.bankapi.entity.Customer;
import com.workintech.bankapi.service.AddressService;
import com.workintech.bankapi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping("/")
    public List<Customer> getAll(){
        return customerService.getAll();
    }

    @GetMapping("/{id}")
    public Customer getById(@PathVariable int id){
        Optional<Customer> customer = customerService.getById(id);
        if(customer.get() == null){
            return null;
        }
        return customer.get();
    }

    @PostMapping("/")
    public Customer save(@RequestBody Customer customer){
        // validasyon
        return customerService.addCustomer(customer);
    }

    @PutMapping("/{id}")
    public Customer update(@PathVariable int id, @RequestBody Customer customer){
        return customerService.updateCustomer(id, customer);
    }

    @DeleteMapping("/{id}")
    public Customer delete(@PathVariable int id){
        return customerService.deleteCustomer(id);
    }
}
