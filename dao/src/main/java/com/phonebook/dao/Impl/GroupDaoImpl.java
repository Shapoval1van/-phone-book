package com.phonebook.dao.Impl;


import com.phonebook.dao.ContactDao;
import com.phonebook.dao.DataBaseException;
import com.phonebook.dao.GroupDao;
import com.phonebook.model.Contact;
import com.phonebook.model.Group;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Repository
public class GroupDaoImpl implements GroupDao{
    private final String GET_GROUP_BY_USER_ID = "from Group g where g.creator.id = :id or g.isDefault = true";
    private final String DELETE_CONTACTS_BY_GROUP_ID = "delete from Contact c where c.group.id =:id";
    private final String GET_CONTACTS_BY_GROUP_ID = "from Contact c where c.group.id = :id and c.creator.id = :creatorId";
    private static final Logger LOG = Logger.getLogger(ContactDao.class);
    private static String SETVAL_SQL = "SELECT setval('group_c_id_seq', (SELECT MAX(id) FROM group_c)-1)";
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

    public void persist(Group contact) throws DataBaseException{
        if (getCurrentSession() != null) {
            getCurrentSession().save(contact);
        } else {
            LOG.error("Session does not opened");
            throw new DataBaseException("Session does not opened");
        }
    }

    public void update(Group contact) {

    }

    public Group findById(int id) throws DataBaseException {
        if(getCurrentSession()!=null) {
            return getCurrentSession().get(Group.class, id);
        }
        else {
            LOG.error("Session does not opened");
            throw new DataBaseException("Session does not opened");
        }
    }

    public void delete(Group group) throws DataBaseException {
        if(getCurrentSession()!=null) {
            getCurrentSession().delete(group);
            NativeQuery setMaxVal = getCurrentSession().createNativeQuery(SETVAL_SQL).addScalar("setval", StandardBasicTypes.INTEGER);
            setMaxVal.uniqueResult();
        }
        else {
            LOG.error("Session does not opened");
            throw new DataBaseException("Session does not opened");
        }
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

    public Set<Contact> findContactsByGroup(int id, int creatorId) throws DataBaseException{
        Set<Contact> contacts = new TreeSet<>((Contact c1, Contact c2)->
                c1.getFirstName().compareTo(c2.getFirstName())
        );
        if (getCurrentSession() != null) {
            Query query = getCurrentSession().createQuery(GET_CONTACTS_BY_GROUP_ID);
            query.setParameter("id",id);
            query.setParameter("creatorId", creatorId);
            contacts.addAll(query.list());
            return contacts;
        } else {
            LOG.error("Session does not opened");
            throw new DataBaseException("Session does not opened");
        }
    }

    @Override
    public void deleteAllContactsByGroupId(int id) throws DataBaseException {
        if(getCurrentSession()!=null) {
            Query deleteContacts = getCurrentSession().createQuery(DELETE_CONTACTS_BY_GROUP_ID);
            deleteContacts.setParameter("id",id);
            deleteContacts.executeUpdate();
            NativeQuery setMaxVal = getCurrentSession().createNativeQuery(SETVAL_SQL).addScalar("setval", StandardBasicTypes.INTEGER);
            setMaxVal.uniqueResult();
        }
        else {
            LOG.error("Session does not opened");
            throw new DataBaseException("Session does not opened");
        }

    }
}
