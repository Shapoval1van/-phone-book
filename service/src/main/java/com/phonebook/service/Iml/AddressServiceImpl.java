package com.phonebook.service.Iml;

import com.phoneBook.dao.AddressDao;
import com.phoneBook.dao.DataBaseException;
import com.phoneBook.dao.Impl.AddressDaoImpl;
import com.phoneBook.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AddressServiceImpl implements AddressDao {
    @Autowired
    private AddressDaoImpl addressDao;


    public void persist(Address address) throws DataBaseException {
        try {
            addressDao.openSessionWithTransaction();
            addressDao.persist(address);
            addressDao.closeSessionWithTransaction();
        }catch (DataBaseException e){
            addressDao.getCurrentTransaction().rollback();
            addressDao.closeSessionWithTransaction();
        }
    }

    public void update(Address address) throws DataBaseException {
        try {
            addressDao.openSessionWithTransaction();
            addressDao.update(address);
            addressDao.closeSessionWithTransaction();
        }catch (DataBaseException e){
            addressDao.getCurrentTransaction().rollback();
            addressDao.closeSessionWithTransaction();
        }
    }

    public Address findById(int id) throws DataBaseException {
        try {
            addressDao.openSessionWithTransaction();
            Address address =  addressDao.findById(id);
            addressDao.closeSessionWithTransaction();
            return address;
        }catch (DataBaseException e){
            addressDao.getCurrentTransaction().rollback();
            addressDao.closeSessionWithTransaction();
            return null;
        }
    }

    public void delete(Address address) throws DataBaseException {
        try {
            addressDao.openSessionWithTransaction();
            addressDao.delete(address);
            addressDao.closeSessionWithTransaction();
        }catch (DataBaseException e){
            addressDao.getCurrentTransaction().rollback();
            addressDao.closeSessionWithTransaction();
        }
    }

    public Set<Address> findAll() throws DataBaseException {
        try {
            addressDao.openSessionWithTransaction();
            HashSet<Address> addresses = (HashSet<Address>) addressDao.findAll();
            addressDao.closeSessionWithTransaction();
            return addresses;
        }catch (DataBaseException e){
            addressDao.getCurrentTransaction().rollback();
            addressDao.closeSessionWithTransaction();
            return null;
        }
    }

    public void deleteAll() throws DataBaseException {
        try {
            addressDao.openSessionWithTransaction();
            addressDao.deleteAll();
            addressDao.closeSessionWithTransaction();
        }catch (DataBaseException e){
            addressDao.getCurrentTransaction().rollback();
            addressDao.closeSessionWithTransaction();
        }
    }
}
