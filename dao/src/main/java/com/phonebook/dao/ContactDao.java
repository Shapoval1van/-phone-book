package com.phonebook.dao;

import com.phonebook.model.Contact;

import java.util.Set;

public interface ContactDao {

    public void persist(Contact contact);

    public void update(Contact contact);

    public Contact findById(int id);

    public void delete(Contact contact);

    public Set<Contact> findAll();

    public void deleteAll();

}
