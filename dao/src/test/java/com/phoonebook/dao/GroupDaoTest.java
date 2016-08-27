package com.phoonebook.dao;

import com.phonebook.dao.DataBaseException;
import com.phonebook.dao.Impl.ContactDaoImpl;
import com.phonebook.dao.Impl.GroupDaoImpl;
import com.phonebook.model.Contact;
import com.phonebook.model.Group;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Set;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:test-context.xml")
public class GroupDaoTest {
    @Autowired
    GroupDaoImpl groupDao;

    @Autowired
    ContactDaoImpl contactDao;

    @Test
    public void getAllByUserId(){
        try {
            groupDao.openSessionWithTransaction();
            ArrayList<Group> groups = (ArrayList<Group>) groupDao.findAllByUserId(1);
            groupDao.closeSessionWithTransaction();
            assertEquals(4, groups.size());
        } catch (DataBaseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findContactsByGroupId(){
        try {
            groupDao.openSessionWithTransaction();
            Set<Contact> contacts = groupDao.findContactsByGroup(1);
            groupDao.closeSessionWithTransaction();
            assertEquals(2, contacts.size());
        } catch (DataBaseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteByContactByGroupId(){
        try {
            groupDao.openSessionWithTransaction();
            assertEquals(2,groupDao.findContactsByGroup(5).size());
            groupDao.deleteAllContactsByGroupId(5);
            assertEquals(0,groupDao.findContactsByGroup(5).size());
            groupDao.getCurrentTransaction().rollback();
            groupDao.closeCurrentSession();
        } catch (DataBaseException e) {
            groupDao.getCurrentTransaction().rollback();
            groupDao.closeCurrentSession();
            e.printStackTrace();
        }
    }
}
