package com.phoneBook.dao.Impl;

import com.phoneBook.dao.AddressDao;
import com.phoneBook.dao.DataBaseException;
import com.phoneBook.model.Address;
import com.phoneBook.model.Contact;
import com.phoneBook.model.Lang;
import com.phoneBook.model.User;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Set;

public class AddressDaoImpl implements AddressDao{

    private static final Logger LOGER = Logger.getLogger(AddressDao.class);

    private Session currentSession;
    private Transaction currentTransaction;

    private static SessionFactory getSessionFactory(){
        Configuration configuration = new Configuration().configure();
        configuration.addAnnotatedClass(Address.class);
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

    public void persist(Address address) throws DataBaseException {
        if(getCurrentSession()!=null) {
            getCurrentSession().save(address);
        }
        else {
            LOGER.error("Session does not opened");
            throw new DataBaseException("Session does not opened");
        }
    }

    public void update(Address address) throws DataBaseException {
        if(getCurrentSession()!=null) {
            getCurrentSession().update(address);
        }
        else {
            LOGER.error("Session does not opened");
            throw new DataBaseException("Session does not opened");
        }
    }

    public Address findById(int id) {
        return null;
    }

    public int delete(Address address) {

        return 0;
    }

    public Set<Address> findAll() {
        return null;
    }

    public int deleteAll() {

        return 0;
    }
}
