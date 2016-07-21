package com.phonebook.dao;

import com.phoneBook.model.Address;

import java.util.Set;

public interface AddressDao {

    public void persist(Address user) throws DataBaseException;

    public void update(Address user) throws DataBaseException;

    public Address findById(int id) throws DataBaseException;

    public void delete(Address user) throws DataBaseException;

    public Set<Address> findAll() throws DataBaseException;

    public void deleteAll() throws DataBaseException;
}
