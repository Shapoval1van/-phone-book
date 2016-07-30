package com.phoonebook.dao;


import com.phonebook.dao.DataBaseException;
import com.phonebook.dao.Impl.UserDaoImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:test-context.xml")
public class UserDaoTest {

    @Autowired
    UserDaoImpl userDao;

    @Test
    public void findByUserName(){
        try {
            userDao.openSessionWithTransaction();
            Assert.assertEquals("12geribi",userDao.findUserByUsername("Jungle").getPassword());

            userDao.closeSessionWithTransaction();
        } catch (DataBaseException e) {
            e.printStackTrace();
        }
    }
}   

