package com.phoonebook.dao;


import com.phonebook.dao.DataBaseException;
import com.phonebook.dao.Impl.AddressDaoImpl;
import com.phonebook.model.Address;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashSet;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:test-context.xml")
public class AddressDaoTest {

    @Autowired
    AddressDaoImpl addressDao;

    @Test
    public void updateFindByIdTest() {
        try {
            Address address = new Address(3, "Ukrain","BZ","metall");
            addressDao.openSessionWithTransaction();
            addressDao.update(address);
            assertEquals(address.getCountryName(), addressDao.findById(3).getCountryName());
        } catch (DataBaseException e) {
            addressDao.closeSessionWithTransaction();
            addressDao.getCurrentTransaction().rollback();
            e.printStackTrace();
        }
    }

    @Test
    public void findAllTest() {
        try {
            addressDao.openSessionWithTransaction();
            HashSet<Address> addresss = (HashSet<Address>) addressDao.findAll();
            assertEquals(3, addresss.size());
        } catch (DataBaseException e) {
            addressDao.closeSessionWithTransaction();
            addressDao.getCurrentTransaction().rollback();
            e.printStackTrace();
        }
    }

    @Test
    public void persistDeleteTest() {
        try {
            Address address = new Address(4, "Ukrain","BZ","metall");
            addressDao.openSessionWithTransaction();
            addressDao.persist(address);
            assertEquals(address.getCountryName(), addressDao.findById(4).getCountryName());
            addressDao.delete(address);
        } catch (DataBaseException e) {
            addressDao.closeSessionWithTransaction();
            addressDao.getCurrentTransaction().rollback();
            e.printStackTrace();
        }
    }

}   

