package com.phooneBook.dao;

import com.phoneBook.dao.DataBaseException;
import com.phoneBook.dao.Impl.AddressDaoImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("dao\\src\\main\\resources\\application-context.xml")
public class DBUnitConfig{

     @Test
    public void addressTest(){
         AddressDaoImpl addressDao = new AddressDaoImpl();

         try {
             addressDao.openSessionWithTransaction();
             System.out.print(addressDao.findById(1).toString());
             addressDao.openSessionWithTransaction();
         } catch (DataBaseException e) {
             addressDao.closeSessionWithTransaction();
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
