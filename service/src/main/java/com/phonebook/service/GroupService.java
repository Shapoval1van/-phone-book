package com.phonebook.service;


import com.phonebook.model.Group;

import java.util.List;
import java.util.Set;

public interface GroupService {
    public void persist(Group lang);

    public void update(Group lang);

    public Group findById(int id);

    public void delete(Group lang);

    public Set<Group> findAll();

    public void deleteAll();

    public List<Group> findByUserId(int id);
}
