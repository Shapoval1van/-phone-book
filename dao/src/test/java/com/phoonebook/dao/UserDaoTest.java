package com.phoonebook.dao;


import com.phonebook.dao.DataBaseException;
import com.phonebook.dao.Impl.UserDaoImpl;
import com.phonebook.model.User;
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
    @Test
    public void persistTest(){
        try {
            User user = new User();
            user.setUserName("Guriamare");
            user.setPassword("123456q");
            user.setPasswordConfirm("1234567q");
            userDao.openSessionWithTransaction();
            userDao.persist(user);
            Assert.assertTrue(userDao.findById(4).getUserName().equals(user.getUserName()));
            userDao.delete(new User(4));
            userDao.closeSessionWithTransaction();
        }catch (DataBaseException e){
            userDao.getCurrentTransaction().rollback();
            userDao.closeSessionWithTransaction();
        }
    }
}   

