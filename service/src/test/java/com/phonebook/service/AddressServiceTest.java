package com.phonebook.service;

import com.phonebook.dao.AddressDao;
import com.phonebook.dao.DataBaseException;
import com.phonebook.dao.Impl.AddressDaoImpl;
import com.phonebook.model.Address;
import com.phonebook.service.Iml.AddressServiceImpl;
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
public class AddressServiceTest {
    private static final Logger LOG = Logger.getLogger(AddressDao.class);
    private final String COUNTRY_NAME = "Ukraine";
    private final String COUNTRY_NAME_1 = "Ukraine1";


    @InjectMocks
    AddressServiceImpl addressService = new AddressServiceImpl();

    @Mock
    AddressDaoImpl addressDao;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getByIdTest(){
        try {
            when(addressDao.findById(1)).thenReturn(new Address(1,COUNTRY_NAME));
            Assert.assertEquals(addressService.findById(1).getCountryName(),COUNTRY_NAME);
        } catch (DataBaseException e) {
        }
    }

    @Test
    public void findAllTest(){
        HashSet<Address> address = new HashSet<Address>();
        address.add(new Address(1,COUNTRY_NAME));
        address.add(new Address(2,COUNTRY_NAME_1));
        try {
            when(addressDao.findAll()).thenReturn(address);
            Assert.assertEquals(addressService.findAll().size(),address.size());
        } catch (DataBaseException e) {
        }
    }

    @Test
    public void deleteAllTest(){
        try{
            addressService.deleteAll();
            verify(addressDao).deleteAll();
        } catch (DataBaseException e) {
        }
    }

    @Test
    public void deleteTest(){
        try {
            addressService.delete(new Address());
            verify(addressDao).delete((Address) anyObject());
        }catch (DataBaseException e) {
        }
    }

    @Test
    public void persistTest(){
        try {
            addressService.persist(new Address());
            verify(addressDao).persist((Address) anyObject());
        }catch (DataBaseException e) {
        }
    }

    @Test
    public void updateTest(){
        try {
            addressService.update(new Address());
            verify(addressDao).update((Address) anyObject());
        }catch (DataBaseException e) {
        }
    }
}