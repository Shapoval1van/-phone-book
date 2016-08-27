package com.phonebook.dao;


import com.phonebook.model.Contact;
import com.phonebook.model.Group;

import java.util.List;
import java.util.Set;

public interface GroupDao {
    public void persist(Group group) throws DataBaseException;

    public void update(Group group);

    public Group findById(int id) throws DataBaseException;

    public void delete(Group group) throws DataBaseException;

    public Set<Group> findAll();

    public void deleteAll();

    public List findAllByUserId(int id) throws DataBaseException;

    public Set<Contact> findContactsByGroup(int id) throws DataBaseException;

    public void deleteAllContactsByGroupId(int id)throws DataBaseException;
}
