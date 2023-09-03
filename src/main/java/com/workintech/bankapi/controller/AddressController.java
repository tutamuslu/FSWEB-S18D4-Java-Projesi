package com.workintech.bankapi.controller;

import com.workintech.bankapi.entity.Address;
import com.workintech.bankapi.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/address")
public class AddressController {

    private AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService){
        this.addressService = addressService;
    }

    @GetMapping("/")
    public List<Address> getAll(){
        return addressService.getAll();
    }

    @GetMapping("/{id}")
    public Address getById(@PathVariable int id){
        Optional<Address> address = addressService.getById(id);
        if(address.get() == null){
            return null;
        }
        return address.get();
    }

    @PostMapping("/")
    public Address save(@RequestBody Address address){
        // validasyon
        return addressService.addAddress(address);
    }

    @PutMapping("/{id}")
    public Address update(@PathVariable int id, @RequestBody Address address){
        return addressService.updateAddress(id, address);
    }

    @DeleteMapping("/{id}")
    public Address delete(@PathVariable int id){
        return addressService.deleteAddress(id);
    }
}
