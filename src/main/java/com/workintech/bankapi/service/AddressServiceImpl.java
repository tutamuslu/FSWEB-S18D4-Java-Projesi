package com.workintech.bankapi.service;

import com.workintech.bankapi.dao.AddressRepository;
import com.workintech.bankapi.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService{
    private AddressRepository addressRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository){
        this.addressRepository = addressRepository;
    }

    @Override
    public List<Address> getAll() {
        return addressRepository.findAll();
    }

    @Override
    public Optional<Address> getById(int id) {
        return addressRepository.findById(id);
    }

    @Override
    public Address addAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address updateAddress(int id, Address address) {
        address.setId(id);
        return addressRepository.save(address);
    }

    @Override
    public Address deleteAddress(int id) {
        Optional<Address> address = addressRepository.findById(id);
        if(address != null){
            addressRepository.deleteById(id);
            return address.get();
        }
        return null;
    }
}
