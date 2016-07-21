package com.phonebook.service;

import com.phonebook.model.Contact;

import java.util.Set;

public interface ContactService {
    public void persist(Contact contact);

    public void update(Contact contact);

    public Contact findById(int id);

    public void delete(Contact contact);

    public Set<Contact> findAll();

    public void deleteAll();
}
