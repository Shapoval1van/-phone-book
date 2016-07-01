package com.phoneBook.dao;

import com.phoneBook.model.Lang;

import java.util.Set;

public interface LangDao {

    public void persist(Lang user);

    public void update(Lang user);

    public Lang findById(int id);

    public void delete(Lang user);

    public Set<Lang> findAll();

    public void deleteAll();
}
