package com.phonebook.dao;

import com.phonebook.model.Lang;

import java.util.Set;

public interface LangDao {

    public void persist(Lang lang);

    public void update(Lang lang);

    public Lang findById(int id);

    public void delete(Lang lang);

    public Set<Lang> findAll();

    public void deleteAll();
}
