package com.phonebook.service;


import com.phonebook.model.Contact;
import com.phonebook.model.Group;

import java.util.List;
import java.util.Set;

public interface GroupService {
    public void persist(Group group);

    public void update(Group group);

    public Group findById(int id);

    public void delete(Group group);

    public Set<Group> findAll();

    public void deleteAll();

    public List<Group> findByUserId(int id);

    public Set<Contact> findContactsByGroupId(int id, int creatorId);

    public void deleteContactsByGroupId(int id);
}
