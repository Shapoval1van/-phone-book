package com.phoneBook.dao;



public interface DaoFactory {
    public AddressDao getAddressDao();
    public ContactDao getContactDao();
    public LangDao getLangDao();
    public UserDao getUserDao();
}
