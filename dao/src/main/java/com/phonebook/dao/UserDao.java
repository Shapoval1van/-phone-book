package com.phonebook.dao;

import com.phonebook.model.User;

import java.util.Set;

public interface UserDao {

    public void persist(User user) throws DataBaseException;

    public void update(User user) throws DataBaseException;

    public User findById(int id) throws DataBaseException;

    public void delete(User user) throws DataBaseException;

    public Set<User> findAll() throws DataBaseException;

    public void deleteAll() throws DataBaseException;

    public User findUserByUsername(String name)throws DataBaseException;
}
