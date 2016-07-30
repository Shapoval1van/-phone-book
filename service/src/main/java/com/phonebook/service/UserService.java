package com.phonebook.service;

import com.phonebook.model.User;

import java.util.Set;

public interface UserService {
    public void persist(User user);

    public void update(User user);

    public User findById(int id);

    public void delete(User user);

    public Set<User> findAll();

    public void deleteAll();
}
