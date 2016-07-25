package com.phonebook.dao;


import com.phonebook.model.Group;

import java.util.List;
import java.util.Set;

public interface GroupDao {
    public void persist(Group contact);

    public void update(Group contact);

    public Group findById(int id);

    public void delete(Group contact);

    public Set<Group> findAll();

    public void deleteAll();

    public List findAllByUserId(int id) throws DataBaseException;

}
