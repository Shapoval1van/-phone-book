package com.phonebook.service;

import com.phoneBook.dao.AddressDao;
import com.phoneBook.dao.DataBaseException;
import com.phoneBook.dao.Impl.AddressDaoImpl;
import com.phoneBook.model.Address;
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
        HashSet<Address> addresss = new HashSet<Address>();
        addresss.add(new Address(1,COUNTRY_NAME));
        addresss.add(new Address(2,COUNTRY_NAME_1));
        try {
            when(addressDao.findAll()).thenReturn(addresss);
            Assert.assertEquals(addressService.findAll().size(),addresss.size());
        } catch (DataBaseException e) {
        }
    }
}