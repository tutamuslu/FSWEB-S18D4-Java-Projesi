package com.workintech.bankapi.service;

import com.workintech.bankapi.entity.Address;

import java.util.List;
import java.util.Optional;

public interface AddressService {
    List<Address> getAll();
    Optional<Address> getById(int id);
    Address addAddress(Address address);
    Address updateAddress(int id, Address address);
    Address deleteAddress(int id);
}
