package com.phonebook.service.Iml;

import com.phonebook.dao.DataBaseException;
import com.phonebook.dao.Impl.UserDaoImpl;
import com.phonebook.model.User;
import com.phonebook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private UserDaoImpl userDao;

    public UserDaoImpl getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    public void persist(User user) {
        try {
            userDao.openSessionWithTransaction();
            userDao.persist(user);
            userDao.closeSessionWithTransaction();
        } catch (DataBaseException e) {
            userDao.getCurrentTransaction().rollback();
            userDao.closeSessionWithTransaction();
        }
    }

    public void update(User user) {
        try {
            userDao.openSessionWithTransaction();
            userDao.update(user);
            userDao.closeSessionWithTransaction();
        } catch (DataBaseException e) {
            userDao.getCurrentTransaction().rollback();
            userDao.closeSessionWithTransaction();
        }
    }

    public User findById(int id) {
        try {
            userDao.openSessionWithTransaction();
            User user = userDao.findById(id);
            userDao.closeSessionWithTransaction();
            return user;
        } catch (DataBaseException e) {
            userDao.getCurrentTransaction().rollback();
            userDao.closeSessionWithTransaction();
            return null;
        }
    }

    public void delete(User user) {
        try {
            userDao.openSessionWithTransaction();
            userDao.delete(user);
            userDao.closeSessionWithTransaction();
        } catch (DataBaseException e) {
            userDao.getCurrentTransaction().rollback();
            userDao.closeSessionWithTransaction();
        }
    }

    public Set<User> findAll() {
        try {
            userDao.openSessionWithTransaction();
            HashSet<User> useres = (HashSet<User>) userDao.findAll();
            userDao.closeSessionWithTransaction();
            return useres;
        } catch (DataBaseException e) {
            userDao.getCurrentTransaction().rollback();
            userDao.closeSessionWithTransaction();
            return null;
        }
    }

    public void deleteAll() {
        try {
            userDao.openSessionWithTransaction();
            userDao.deleteAll();
            userDao.closeSessionWithTransaction();
        } catch (DataBaseException e) {
            userDao.getCurrentTransaction().rollback();
            userDao.closeSessionWithTransaction();
        }
    }

    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        try {
            userDao.openSessionWithTransaction();
            User user = userDao.findUserByUsername(name);
            userDao.closeSessionWithTransaction();
            List<SimpleGrantedAuthority> auths = new java.util.ArrayList<SimpleGrantedAuthority>();
            auths.add(new SimpleGrantedAuthority("ROLE_USER"));
            return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), auths);
        } catch (DataBaseException e) {
            userDao.closeSessionWithTransaction();
            throw new UsernameNotFoundException("Don't found user for this username or password");
        }
    }

    public User findUserByUsername(String name) {
        try {
            userDao.openSessionWithTransaction();
            User user = userDao.findUserByUsername(name);
            userDao.closeSessionWithTransaction();
            return user;
        } catch (DataBaseException e) {
            userDao.closeSessionWithTransaction();
            return null;
        }
    }
}
