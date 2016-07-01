package com.phoneBook.dao.Impl;

import com.phoneBook.dao.*;

public class DaoFactoryImpl implements DaoFactory {

    public AddressDao getAddressDao() {
        return new;
    }

    public ContactDao getContactDao() {
        return null;
    }

    public LangDao getLangDao() {
        return null;
    }

    public UserDao getUserDao() {
        return null;
    }
}
