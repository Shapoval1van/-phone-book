package com.phonebook.dao.Impl;


import com.phonebook.dao.ContactDao;
import com.phonebook.dao.DataBaseException;
import com.phonebook.dao.GroupDao;
import com.phonebook.model.Group;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public class GroupDaoImpl implements GroupDao{
    private final String GET_GROUP_BY_USER_ID = "from Group g where g.creator.id = :id or g.isDefault = true";
    private static final Logger LOG = Logger.getLogger(ContactDao.class);
    private Session currentSession;
    private Transaction currentTransaction;
    private SessionFactory sessionFactory;
    @Autowired()
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

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
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

    public void persist(Group contact) {

    }

    public void update(Group contact) {

    }

    public Group findById(int id) {
        return null;
    }

    public void delete(Group contact) {

    }

    public Set<Group> findAll() {
        return null;
    }

    public void deleteAll() {

    }


    public List<Group> findAllByUserId(int id) throws DataBaseException {
        if (getCurrentSession() != null) {
            Query query = getCurrentSession().createQuery(GET_GROUP_BY_USER_ID);
            query.setParameter("id",id);
            return query.list();
        } else {
            LOG.error("Session does not opened");
            throw new DataBaseException("Session does not opened");
        }
    }
}
