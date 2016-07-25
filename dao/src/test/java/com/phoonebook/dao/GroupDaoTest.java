package com.phoonebook.dao;

import com.phonebook.dao.DataBaseException;
import com.phonebook.dao.Impl.GroupDaoImpl;
import com.phonebook.model.Group;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:test-context.xml")
public class GroupDaoTest {
    @Autowired
    GroupDaoImpl groupDao;

    @Test
    public void getAllByUserId(){
            try {
                groupDao.openSessionWithTransaction();
                ArrayList<Group> groups = (ArrayList<Group>) groupDao.findAllByUserId(1);
                groupDao.closeSessionWithTransaction();
                assertEquals(4,groups.size());
            } catch (DataBaseException e) {
                e.printStackTrace();
            }
    }
}
