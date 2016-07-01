package com.phoneBook.dao;

import com.phoneBook.model.Address;

import java.util.Set;

public interface AddressDao {

    public void persist(Address user) throws DataBaseException;

    public void update(Address user) throws DataBaseException;

    public Address findById(int id);

    public int delete(Address user);

    public Set<Address> findAll();

    public int deleteAll();
}
