package com.phonebook.service;


import com.phoneBook.dao.AddressDao;
import com.phoneBook.dao.DataBaseException;
import com.phoneBook.dao.Impl.UserDaoImpl;
import com.phoneBook.model.User;
import com.phonebook.service.Iml.UserServiceImpl;
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
public class UserServiceTest {
    private static final Logger LOG = Logger.getLogger(AddressDao.class);
    private final String USER_NAME = "Ivan";
    private final String USER_NAME_1 = "Ivan1";


    @InjectMocks
    UserServiceImpl userService = new UserServiceImpl();

    @Mock
    UserDaoImpl userDao;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getByIdTest(){
        User user = new User();
        user.setId(1);
        user.setUserName(USER_NAME);
        try {
            when(userDao.findById(1)).thenReturn(user);
            Assert.assertEquals(userService.findById(1).getUserName(),USER_NAME);
        } catch (DataBaseException e) {
        }
    }

    @Test
    public void findAllTest(){
        HashSet<User> users = new HashSet<User>();
        User user = new User();
        user.setId(1);
        user.setUserName(USER_NAME_1);
        users.add(user);
        User user1 = new User();
        user1.setId(1);
        user1.setUserName(USER_NAME_1);
        users.add(user1);
        try {
            when(userDao.findAll()).thenReturn(users);
            Assert.assertEquals(userService.findAll().size(),users.size());
        } catch (DataBaseException e) {
        }
    }
    @Test
    public void deleteAllTest(){
        try{
            userService.deleteAll();
            verify(userDao).deleteAll();
        } catch (DataBaseException e) {
        }
    }

    @Test
    public void deleteTest(){
        try {
            userService.delete(new User());
            verify(userDao).delete((User) anyObject());
        }catch (DataBaseException e) {
        }
    }

    @Test
    public void persistTest(){
        try {
            userService.persist(new User());
            verify(userDao).persist((User) anyObject());
        }catch (DataBaseException e) {
        }
    }

    @Test
    public void updateTest(){
        try {
            userService.update(new User());
            verify(userDao).update((User) anyObject());
        }catch (DataBaseException e) {
        }
    }
}