package com.phonebook.service.Iml;


import com.phonebook.dao.DataBaseException;
import com.phonebook.dao.Impl.ContactDaoImpl;
import com.phonebook.model.Contact;
import com.phonebook.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ContactServiceImpl implements ContactService{


    private ContactDaoImpl contactDao;

    @Autowired
    public void setContactDao(ContactDaoImpl contactDao) {
        this.contactDao = contactDao;
    }

    public void persist(Contact contact) {
        try {
            contactDao.openSessionWithTransaction();
            contactDao.persist(contact);
            contactDao.closeSessionWithTransaction();
        }catch (DataBaseException e){
            contactDao.getCurrentTransaction().rollback();
            contactDao.closeSessionWithTransaction();
        }
    }

    public void update(Contact contact) {
        try {
            contactDao.openSessionWithTransaction();
            contactDao.update(contact);
            contactDao.closeSessionWithTransaction();
        }catch (DataBaseException e){
            contactDao.getCurrentTransaction().rollback();
            contactDao.closeSessionWithTransaction();
        }
    }

    public Contact findById(int id) {
        try {
            contactDao.openSessionWithTransaction();
            Contact contact =  contactDao.findById(id);
            contactDao.closeSessionWithTransaction();
            return contact;
        }catch (DataBaseException e){
            contactDao.getCurrentTransaction().rollback();
            contactDao.closeSessionWithTransaction();
            return null;
        }
    }

    public void delete(Contact contact) {
        try {
            contactDao.openSessionWithTransaction();
            contactDao.delete(contact);
            contactDao.closeSessionWithTransaction();
        }catch (DataBaseException e){
            contactDao.getCurrentTransaction().rollback();
            contactDao.closeSessionWithTransaction();
        }
    }

    public Set<Contact> findAll() {
        try {
            contactDao.openSessionWithTransaction();
            HashSet<Contact> contacts = (HashSet<Contact>) contactDao.findAll();
            contactDao.closeSessionWithTransaction();
            return contacts;
        }catch (DataBaseException e){
            contactDao.getCurrentTransaction().rollback();
            contactDao.closeSessionWithTransaction();
            return null;
        }
    }

    public void deleteAll() {
        try {
            contactDao.openSessionWithTransaction();
            contactDao.deleteAll();
            contactDao.closeSessionWithTransaction();
        }catch (DataBaseException e){
            contactDao.getCurrentTransaction().rollback();
            contactDao.closeSessionWithTransaction();
        }
    }
}
