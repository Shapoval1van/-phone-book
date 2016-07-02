package com.phoneBook.dao.Impl;


import com.phoneBook.dao.DataBaseException;
import com.phoneBook.model.Lang;
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

public class LangDaoImpl {
    private static final Logger LOG = Logger.getLogger(LangDaoImpl.class);
    private static String FIND_ALL = "from com.phoneBook.model.Lang";
    private static String DELETE__ALL = "delete from com.phoneBook.model.Lang";

    private Session currentSession;
    private Transaction currentTransaction;

    private static SessionFactory getSessionFactory(){
        Configuration configuration = new Configuration().configure();
        configuration.addAnnotatedClass(Lang.class);
        configuration.addAnnotatedClass(Contact.class);
        configuration.addAnnotatedClass(Lang.class);
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

    public void persist(Lang lang) throws DataBaseException {
        if(getCurrentSession()!=null) {
            getCurrentSession().save(lang);
        }
        else {
            LOG.error("Session does not opened");
            throw new DataBaseException("Session does not opened");
        }
    }

    public void update(Lang lang) throws DataBaseException {
        if(getCurrentSession()!=null) {
            getCurrentSession().update(lang);
        }
        else {
            LOG.error("Session does not opened");
            throw new DataBaseException("Session does not opened");
        }
    }

    public Lang findById(int id) throws DataBaseException {
        if(getCurrentSession()!=null) {
            return getCurrentSession().get(Lang.class, id);
        }
        else {
            LOG.error("Session does not opened");
            throw new DataBaseException("Session does not opened");
        }
    }

    public void delete(Lang lang) throws DataBaseException {
        if(getCurrentSession()!=null) {
            getCurrentSession().delete(lang);
        }
        else {
            LOG.error("Session does not opened");
            throw new DataBaseException("Session does not opened");
        }
    }

    public Set<Lang> findAll() throws DataBaseException {
        if(getCurrentSession()!=null) {
            return new HashSet<Lang>(getCurrentSession().createQuery(FIND_ALL).list());
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
