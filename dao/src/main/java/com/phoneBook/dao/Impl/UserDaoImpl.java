package com.phoneBook.dao.Impl;

import com.phoneBook.dao.DataBaseException;
import com.phoneBook.model.Contact;
import com.phoneBook.model.User;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.Set;

public class UserDaoImpl {

    private static final Logger LOG = Logger.getLogger(UserDaoImpl.class);
    private static String FIND_ALL = "from com.phoneBook.model.User";
    private static String DELETE__ALL = "delete from com.phoneBook.model.User";

    private Session currentSession;
    private Transaction currentTransaction;

    private static SessionFactory getSessionFactory(){
        Configuration configuration = new Configuration().configure();
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Contact.class);
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(User.class);
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        return sessionFactory;

    }

    public Session openCurrentSession(){
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }

    public void closeCurrentSession(){
        currentSession.close();
    }

    public Session openSessionWithTransaction(){
        currentSession = openCurrentSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeSessionWithTransaction(){
        currentTransaction.commit();
        currentSession.close();
    }

    private Session getCurrentSession() {
        return currentSession;
    }

    public void persist(User user) throws DataBaseException {
        if(getCurrentSession()!=null) {
            getCurrentSession().save(user);
        }
        else {
            LOG.error("Session does not opened");
            throw new DataBaseException("Session does not opened");
        }
    }

    public void update(User user) throws DataBaseException {
        if(getCurrentSession()!=null) {
            getCurrentSession().update(user);
        }
        else {
            LOG.error("Session does not opened");
            throw new DataBaseException("Session does not opened");
        }
    }

    public User findById(int id) throws DataBaseException {
        if(getCurrentSession()!=null) {
            return getCurrentSession().get(User.class, id);
        }
        else {
            LOG.error("Session does not opened");
            throw new DataBaseException("Session does not opened");
        }
    }

    public void delete(User user) throws DataBaseException {
        if(getCurrentSession()!=null) {
            getCurrentSession().delete(user);
        }
        else {
            LOG.error("Session does not opened");
            throw new DataBaseException("Session does not opened");
        }
    }

    public Set<User> findAll() throws DataBaseException {
        if(getCurrentSession()!=null) {
            return new HashSet<User>(getCurrentSession().createQuery(FIND_ALL).list());
        }
        else {
            LOG.error("Session does not opened");
            throw new DataBaseException("Session does not opened");
        }
    }

    public void deleteAll() throws DataBaseException {
        if(getCurrentSession()!=null) {
            getCurrentSession().createQuery(DELETE__ALL).list();
        }
        else {
            LOG.error("Session does not opened");
            throw new DataBaseException("Session does not opened");
        }
    }
}
