package com.phonebook.service.Iml;


import com.phoneBook.dao.DataBaseException;
import com.phoneBook.dao.Impl.LangDaoImpl;
import com.phoneBook.model.Lang;
import com.phonebook.service.LangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class LangServiceImpl implements LangService {
    @Autowired
    LangDaoImpl langDao;


    public void persist(Lang lang)  {
        try {
            langDao.openSessionWithTransaction();
            langDao.persist(lang);
            langDao.closeSessionWithTransaction();
        }catch (DataBaseException e){
            langDao.getCurrentTransaction().rollback();
            langDao.closeSessionWithTransaction();
        }
    }

    public void update(Lang lang)  {
        try {
            langDao.openSessionWithTransaction();
            langDao.update(lang);
            langDao.closeSessionWithTransaction();
        }catch (DataBaseException e){
            langDao.getCurrentTransaction().rollback();
            langDao.closeSessionWithTransaction();
        }
    }

    public Lang findById(int id)  {
        try {
            langDao.openSessionWithTransaction();
            Lang lang =  langDao.findById(id);
            langDao.closeSessionWithTransaction();
            return lang;
        }catch (DataBaseException e){
            langDao.getCurrentTransaction().rollback();
            langDao.closeSessionWithTransaction();
            return null;
        }
    }

    public void delete(Lang lang)  {
        try {
            langDao.openSessionWithTransaction();
            langDao.delete(lang);
            langDao.closeSessionWithTransaction();
        }catch (DataBaseException e){
            langDao.getCurrentTransaction().rollback();
            langDao.closeSessionWithTransaction();
        }
    }

    public Set<Lang> findAll()  {
        try {
            langDao.openSessionWithTransaction();
            HashSet<Lang> langes = (HashSet<Lang>) langDao.findAll();
            langDao.closeSessionWithTransaction();
            return langes;
        }catch (DataBaseException e){
            langDao.getCurrentTransaction().rollback();
            langDao.closeSessionWithTransaction();
            return null;
        }
    }

    public void deleteAll()  {
        try {
            langDao.openSessionWithTransaction();
            langDao.deleteAll();
            langDao.closeSessionWithTransaction();
        }catch (DataBaseException e){
            langDao.getCurrentTransaction().rollback();
            langDao.closeSessionWithTransaction();
        }
    }
}
