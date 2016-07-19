package com.phonebook.service;

import com.phoneBook.dao.ContactDao;
import com.phoneBook.dao.DataBaseException;
import com.phoneBook.dao.Impl.ContactDaoImpl;
import com.phoneBook.model.Contact;
import com.phonebook.service.Iml.ContactServiceImpl;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.HashSet;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ContactServiceTest {
    private static final Logger LOG = Logger.getLogger(ContactDao.class);
    private final String USER_NAME = "Ivan";
    private final String USER_NAME_1 = "Ivan1";


    @InjectMocks
    ContactServiceImpl contactService = new ContactServiceImpl();

    @Mock
    ContactDaoImpl contactDao;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getByIdTest(){
        Contact contact = new Contact();
        contact.setId(1);
        contact.setFirstName(USER_NAME);
        try {
            when(contactDao.findById(1)).thenReturn(contact);
            Assert.assertEquals(contactService.findById(1).getFirstName(),USER_NAME);
        } catch (DataBaseException e) {
        }
    }

    @Test
    public void findAllTest(){
        HashSet<Contact> contacts = new HashSet<Contact>();
        Contact contact = new Contact();
        contact.setId(1);
        contact.setFirstName(USER_NAME_1);
        contacts.add(contact);
        Contact contact1 = new Contact();
        contact1.setId(1);
        contact1.setFirstName(USER_NAME_1);
        contacts.add(contact1);
        try {
            when(contactDao.findAll()).thenReturn(contacts);
            Assert.assertEquals(contactService.findAll().size(),contacts.size());
        } catch (DataBaseException e) {
        }
    }

    @Test
    public void deleteAllTest(){
        try{
            contactService.deleteAll();
            verify(contactDao).deleteAll();
        } catch (DataBaseException e) {
        }
    }

    @Test
    public void deleteTest(){
        try {
            contactService.delete(new Contact());
            verify(contactDao).delete((Contact) anyObject());
        }catch (DataBaseException e) {
        }
    }

    @Test
    public void persistTest(){
        try {
            contactService.persist(new Contact());
            verify(contactDao).persist((Contact) anyObject());
        }catch (DataBaseException e) {
        }
    }

    @Test
    public void updateTest(){
        try {
            contactService.update(new Contact());
            verify(contactDao).update((Contact) anyObject());
        }catch (DataBaseException e) {
        }
    }
}
