package com.phooneBook.dao;

import com.phonebook.dao.DataBaseException;
import com.phonebook.dao.Impl.AddressDaoImpl;
import com.phonebook.dao.Impl.ContactDaoImpl;
import com.phonebook.dao.Impl.LangDaoImpl;
import com.phoneBook.model.Lang;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashSet;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:test-context.xml")
public class LangDaoTest {

    @Autowired
    AddressDaoImpl addressDao;
    @Autowired
    ContactDaoImpl contactDao;
    @Autowired
    LangDaoImpl langDao;

    @Test
    public void updateFindByIdTest(){
        try{
            Lang lang = new Lang(3,"Makedonia");
            langDao.openSessionWithTransaction();
            langDao.update(lang);
            assertEquals(lang.getLang(),langDao.findById(3).getLang());
        }catch (DataBaseException e){
            addressDao.closeSessionWithTransaction();
            addressDao.getCurrentTransaction().rollback();
            e.printStackTrace();
        }
    }

    @Test
    public void findAllTest(){
        try{
            Lang lang = new Lang(3,"Makedonia");
            langDao.openSessionWithTransaction();
            HashSet<Lang> langs = (HashSet<Lang>) langDao.findAll();
            assertEquals(3,langs.size());
        }catch (DataBaseException e){
            addressDao.closeSessionWithTransaction();
            addressDao.getCurrentTransaction().rollback();
            e.printStackTrace();
        }
    }

    @Test
    public void persistDeleteTest(){
        try{
            Lang lang = new Lang(4,"Makedonia");
            langDao.openSessionWithTransaction();
            langDao.persist(lang);
            assertEquals(lang.getLang(),langDao.findById(4).getLang());
            langDao.delete(lang);
        }catch (DataBaseException e){
            addressDao.closeSessionWithTransaction();
            addressDao.getCurrentTransaction().rollback();
            e.printStackTrace();
        }
    }

}
