package com.hr.test;


import com.hr.UserDao;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class UserDaoJUnitTest04 {
    private Logger LOG = Logger.getLogger(this.getClass());


    // Looks for Bean that matches the type of the variable
    @Autowired
    private ApplicationContext context;

    private UserDao userDao;

    @Before
    public void setup() {
        userDao = context.getBean("userDao", UserDao.class);
        LOG.debug("userDao : " + userDao);
        LOG.debug("context : " + context);
    }

    @Test
    public void isObject() {
        LOG.debug("context : " + context);
    }

    @Test
    public void isObject02() {
        LOG.debug("isObject02 context : " + context);
    }

    @After
    public void tearDown() {

    }

}
