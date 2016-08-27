package com.phonebook.service.Iml;


import com.phonebook.dao.DataBaseException;
import com.phonebook.dao.Impl.GroupDaoImpl;
import com.phonebook.model.Contact;
import com.phonebook.model.Group;
import com.phonebook.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class GroupServiceImpl implements GroupService{

    private GroupDaoImpl groupDao;

    @Autowired
    public void setGroupDao(GroupDaoImpl groupDao) {
        this.groupDao = groupDao;
    }



    public void persist(Group group) {
        try {
            groupDao.openSessionWithTransaction();
            groupDao.persist(group);
            groupDao.closeSessionWithTransaction();
        }catch (DataBaseException e){
            groupDao.getCurrentTransaction().rollback();
            groupDao.closeCurrentSession();
        }
    }

    public void update(Group lang) {

    }

    public Group findById(int id) {
        try {
            groupDao.openSessionWithTransaction();
            Group group = groupDao.findById(id);
            groupDao.closeSessionWithTransaction();
            return group;
        }catch (DataBaseException e){
            groupDao.getCurrentTransaction().rollback();
            groupDao.closeSessionWithTransaction();
            return null;
        }
    }

    public void delete(Group group) {
        try {
            groupDao.openSessionWithTransaction();
            groupDao.delete(group);
            groupDao.closeSessionWithTransaction();
        }catch (DataBaseException e){
            groupDao.getCurrentTransaction().rollback();
            groupDao.closeCurrentSession();
        }
    }

    public Set<Group> findAll() {
        return null;
    }

    public void deleteAll() {

    }

    public List<Group> findByUserId(int id) {
        try {
            groupDao.openSessionWithTransaction();
            ArrayList<Group> groups = (ArrayList<Group>) groupDao.findAllByUserId(id);
            groupDao.closeSessionWithTransaction();
            return groups;
        }catch (DataBaseException e){
            groupDao.getCurrentTransaction().rollback();
            groupDao.closeCurrentSession();
            return null;
        }
    }

    @Override
    public Set<Contact> findContactsByGroupId(int id) {
        try {
            groupDao.openSessionWithTransaction();
            Set<Contact> contacts = groupDao.findContactsByGroup(id);
            groupDao.closeSessionWithTransaction();
            return contacts;
        }catch (DataBaseException e){
            groupDao.getCurrentTransaction().rollback();
            groupDao.closeCurrentSession();
            return null;
        }
    }

    @Override
    public void deleteContactsByGroupId(int id) {
        try {
            groupDao.openSessionWithTransaction();
            groupDao.deleteAllContactsByGroupId(id);
            groupDao.closeSessionWithTransaction();
        }catch (DataBaseException e){
            groupDao.getCurrentTransaction().rollback();
            groupDao.closeCurrentSession();
        }
    }
}
