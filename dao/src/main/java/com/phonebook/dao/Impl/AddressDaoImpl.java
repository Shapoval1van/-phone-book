package com.phonebook.dao.Impl;

import com.phonebook.dao.AddressDao;
import com.phonebook.dao.DataBaseException;
import com.phonebook.model.Address;
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
public class AddressDaoImpl implements AddressDao {

    private static final Logger LOG = Logger.getLogger(AddressDao.class);
    private static String FIND_ALL = "from com.phonebook.model.Address";
    private static String DELETE__ALL = "delete from com.phonebook.model.Address";
    private static String SETVAL_SQL = "SELECT setval('address_id_seq', (SELECT MAX(id) FROM address))";

    private Session currentSession;
    private Transaction currentTransaction;
    private SessionFactory sessionFactory;
    @Autowired
    private LocalSessionFactoryBean sessionFactoryBean;

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public SessionFactory getSessionFactory() {
        return (SessionFactory)sessionFactoryBean.getObject();
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

    public Session openCurrentSession() {
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }

    public void closeCurrentSession() {
        currentSession.close();
    }

    public Session openSessionWithTransaction() {
        currentSession = openCurrentSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeSessionWithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }

    private Session getCurrentSession() {
        return currentSession;
    }

    public void persist(Address address) throws DataBaseException {
        if (getCurrentSession() != null) {
            getCurrentSession().saveOrUpdate(address);
        } else {
            LOG.error("Session does not opened");
            throw new DataBaseException("Session does not opened");
        }
    }

    public void update(Address address) throws DataBaseException {
        if (getCurrentSession() != null) {
            getCurrentSession().update(address);
        } else {
            LOG.error("Session does not opened");
            throw new DataBaseException("Session does not opened");
        }
    }

    public Address findById(int id) throws DataBaseException {
        if (getCurrentSession() != null) {
            return getCurrentSession().get(Address.class, id);
        } else {
            LOG.error("Session does not opened");
            throw new DataBaseException("Session does not opened");
        }
    }

    public void delete(Address address) throws DataBaseException {
        if (getCurrentSession() != null) {
            getCurrentSession().delete(address);
            SQLQuery setMaxVal = getCurrentSession().createSQLQuery(SETVAL_SQL).addScalar("setval", StandardBasicTypes.INTEGER);
            setMaxVal.uniqueResult();
        } else {
            LOG.error("Session does not opened");
            throw new DataBaseException("Session does not opened");
        }
    }

    public Set<Address> findAll() throws DataBaseException {
        if (getCurrentSession() != null) {
            return new HashSet<Address>(getCurrentSession().createQuery(FIND_ALL).list());
        } else {
            LOG.error("Session does not opened");
            throw new DataBaseException("Session does not opened");
        }
    }

    public void deleteAll() throws DataBaseException {
        if (getCurrentSession() != null) {
            getCurrentSession().createQuery(DELETE__ALL).list();
        } else {
            LOG.error("Session does not opened");
            throw new DataBaseException("Session does not opened");
        }
    }
}
