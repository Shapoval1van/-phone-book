package com.phoonebook.dao;


import com.phonebook.dao.DataBaseException;
import com.phonebook.dao.Impl.ContactDaoImpl;
import com.phonebook.model.Address;
import com.phonebook.model.Contact;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashSet;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:test-context.xml")
public class ContactDaoTest {

    @Autowired
    ContactDaoImpl contactDao;



    @Test
    public void updateFindByIdTest() {
        try {
            Contact contact = new Contact();
            contact.setId(4);
            contact.setEmail("DSF@gmail");
            contact.setMobilPhone("fdgdsg");
            contact.setFirstName("Ivan");
            contact.setLastName("Poduvan");
            contact.setAddress(new Address(2,"sdfg","SDfg","Fdg"));
            contactDao.openSessionWithTransaction();
            contactDao.update(contact);
            assertEquals(contact.getFirstName(), contactDao.findById(4).getFirstName());
        } catch (DataBaseException e) {
            contactDao.closeSessionWithTransaction();
            contactDao.getCurrentTransaction().rollback();
            e.printStackTrace();
        }
    }

    @Test
    public void findAllTest() {
        try {
            Contact contact = new Contact();
            contact.setId(5);
            contact.setEmail("DSF@gmail");
            contact.setMobilPhone("fdgdsg");
            contact.setFirstName("Ivan");
            contact.setLastName("Poduvan");
            contact.setAddress(new Address(2,"sdfg","SDfg","Fdg"));
            contactDao.openSessionWithTransaction();
            HashSet<Contact> contacts = (HashSet<Contact>) contactDao.findAll();
            assertEquals(4, contacts.size());
        } catch (DataBaseException e) {
            contactDao.closeSessionWithTransaction();
            contactDao.getCurrentTransaction().rollback();
            e.printStackTrace();
        }
    }

    @Test
    public void persistDeleteTest() {
        try {
            Contact contact = new Contact();
            contact.setId(5);
            contact.setEmail("DSF@gmail");
            contact.setMobilPhone("fdgdsg");
            contact.setFirstName("Ivan");
            contact.setLastName("Poduvan");
            contact.setAddress(new Address(2,"sdfg","SDfg","Fdg"));
            contactDao.openSessionWithTransaction();
            contactDao.persist(contact);
            assertEquals(contact.getFirstName(), contactDao.findById(5).getFirstName());
            contactDao.delete(contact);
        } catch (DataBaseException e) {
            contactDao.closeSessionWithTransaction();
            contactDao.getCurrentTransaction().rollback();
            e.printStackTrace();
        }
    }

}   

