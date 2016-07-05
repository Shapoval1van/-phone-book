package com.phooneBook.dao;

import com.phoneBook.dao.DataBaseException;
import com.phoneBook.dao.Impl.AddressDaoImpl;
import com.phoneBook.dao.Impl.ContactDaoImpl;
import com.phoneBook.model.Address;
import com.phoneBook.model.Contact;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashSet;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:test-context.xml")
public class DBUnitConfig{

    @Autowired
    AddressDaoImpl addressDao;
    @Autowired
    ContactDaoImpl contactDao;


    @Test
    public void addressTest(){

         try {
             addressDao.openSessionWithTransaction();
             contactDao.openSessionWithTransaction();
             for(int i = 1; i < 4; i++){
                 System.out.println(addressDao.findById(i).toString());
             }
             System.out.println(addressDao.findAll().toString());
             HashSet<Contact> contacts = (HashSet<Contact>) contactDao.findAll();
             Contact contact = contactDao.findById(2);
             Address address = contact.getAddress();
             System.out.println("Contact"+contact.getAddress().toString());
             addressDao.closeSessionWithTransaction();
             contactDao.closeSessionWithTransaction();
         } catch (DataBaseException e) {
             addressDao.closeSessionWithTransaction();
             contactDao.closeSessionWithTransaction();
             e.printStackTrace();
         }
     }

//    LangDaoImpl langDao;
//    IDatabaseTester tester;
//
//    @BeforeClass
//    public void init(){
//        langDao = new LangDaoImpl();
//        IDatabaseConnection databaseConnection;
//        try {
//            databaseConnection = new DatabaseConnection(((SessionImpl)langDao.openSessionWithTransaction()).connection());
//            tester = new DefaultDatabaseTester(databaseConnection);
//        } catch (DatabaseUnitException e) {
//            e.printStackTrace();
//        }
//
//
//    }
//
//    @Override
//    protected IDataSet getDataSet() throws Exception {
//        return new FlatXmlDataSet(getClass().getResourceAsStream("dataSetLang.xml"));
//    }
}
