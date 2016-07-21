package com.phonebook.service;

import com.phonebook.dao.AddressDao;
import com.phonebook.dao.DataBaseException;
import com.phonebook.dao.Impl.LangDaoImpl;
import com.phonebook.model.Lang;
import com.phonebook.service.Iml.LangServiceImpl;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.HashSet;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LangServiceTest {
    private static final Logger LOG = Logger.getLogger(AddressDao.class);
    private final String COUNTRY_NAME = "Ukraine";
    private final String COUNTRY_NAME_1 = "Ukraine1";


    @InjectMocks
    LangServiceImpl langService = new LangServiceImpl();

    @Mock
    LangDaoImpl langDao;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getByIdTest(){
        try {
            when(langDao.findById(1)).thenReturn(new Lang(1,COUNTRY_NAME));
            Assert.assertEquals(langService.findById(1).getLang(),COUNTRY_NAME);
        } catch (DataBaseException e) {
        }
    }

    @Test
    public void findAllTest(){
        HashSet<Lang> langs = new HashSet<Lang>();
        langs.add(new Lang(1,COUNTRY_NAME));
        langs.add(new Lang(2,COUNTRY_NAME_1));
        try {
            when(langDao.findAll()).thenReturn(langs);
            Assert.assertEquals(langService.findAll().size(),langs.size());
        } catch (DataBaseException e) {
        }
    }

    @Test
    public void deleteAllTest(){
        try{
            langService.deleteAll();
            verify(langDao).deleteAll();
        } catch (DataBaseException e) {
        }
    }

    @Test
    public void deleteTest(){
        try {
            langService.delete(new Lang());
            verify(langDao).delete((Lang) anyObject());
        }catch (DataBaseException e) {
        }
    }

    @Test
    public void persistTest(){
        try {
            langService.persist(new Lang());
            verify(langDao).persist((Lang) anyObject());
        }catch (DataBaseException e) {
        }
    }

    @Test
    public void updateTest(){
        try {
            langService.update(new Lang());
            verify(langDao).update((Lang) anyObject());
        }catch (DataBaseException e) {
        }
    }
}
