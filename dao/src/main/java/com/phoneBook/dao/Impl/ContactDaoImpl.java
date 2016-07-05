package com.phoneBook.dao.Impl;


import com.phoneBook.dao.ContactDao;
import com.phoneBook.dao.DataBaseException;
import com.phoneBook.model.Contact;
import org.apache.log4j.Logger;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
public class ContactDaoImpl {
    private static final Logger LOG = Logger.getLogger(ContactDao.class);
    private static String FIND_ALL = "from Contact";
    private static String SETVAL_SQL = "SELECT setval('phoneBook.contact_id_seq', (SELECT MAX(id) FROM phoneBook.contact))";
    private static String DELETE__ALL = "delete from com.phoneBook.model.Contact";

    private Session currentSession;
    private Transaction currentTransaction;
    private SessionFactory sessionFactory;
    @Autowired
    private LocalSessionFactoryBean sessionFactoryBean;

    public SessionFactory getSessionFactory() {
        return (SessionFactory) sessionFactoryBean.getObject();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public LocalSessionFactoryBean getSessionFactoryBean() {
        return sessionFactoryBean;
    }

    public void setSessionFactoryBean(LocalSessionFactoryBean sessionFactoryBean) {
        this.sessionFactoryBean = sessionFactoryBean;
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

    public void persist(Contact contact) throws DataBaseException {
        if(getCurrentSession()!=null) {
            getCurrentSession().save(contact);
        }
        else {
            LOG.error("Session does not opened");
            throw new DataBaseException("Session does not opened");
        }
    }

    public void update(Contact contact) throws DataBaseException {
        if(getCurrentSession()!=null) {
            getCurrentSession().update(contact);
        }
        else {
            LOG.error("Session does not opened");
            throw new DataBaseException("Session does not opened");
        }
    }

    public Contact findById(int id) throws DataBaseException {
        if(getCurrentSession()!=null) {
            return getCurrentSession().get(Contact.class, id);
        }
        else {
            LOG.error("Session does not opened");
            throw new DataBaseException("Session does not opened");
        }
    }

    public void delete(Contact contact) throws DataBaseException {
        if(getCurrentSession()!=null) {
            getCurrentSession().delete(contact);
            SQLQuery setMaxVal = getCurrentSession().createSQLQuery(SETVAL_SQL).addScalar("setval", StandardBasicTypes.INTEGER);
            setMaxVal.uniqueResult();
        }
        else {
            LOG.error("Session does not opened");
            throw new DataBaseException("Session does not opened");
        }
    }

    public Set<Contact> findAll() throws DataBaseException {
        if(getCurrentSession()!=null) {
            return new HashSet<Contact>(getCurrentSession().createQuery(FIND_ALL).list());
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
