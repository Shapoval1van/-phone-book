package com.phonebook.service;


import com.phoneBook.model.Address;

import java.util.Set;

public interface AddressService {

    public void persist(Address address);

    public void update(Address address);

    public Address findById(int id);

    public void delete(Address address);

    public Set<Address> findAll();

    public void deleteAll();
}
