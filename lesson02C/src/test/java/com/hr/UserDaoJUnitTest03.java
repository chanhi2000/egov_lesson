package com.hr;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class UserDaoJUnitTest03 {

    private  Logger LOG = Logger.getLogger(this.getClass());
    private ApplicationContext context;
    private UserDao userDao;
    private User user01;
    private User user02;
    private User user03;

    @Before
    public void setup() {
        // Test Data
        user01=new User("c01_58", "이찬희", "1234");
        user02=new User("c02_58", "이찬희", "1234");
        user03=new User("c03_58", "이찬희", "1234");

        context
                = new GenericXmlApplicationContext("/applicationContext.xml");
        LOG.debug("========================");
        LOG.debug("context:"+context);
        LOG.debug("========================");

        userDao=context.getBean("userDao", UserDao.class);
        LOG.debug("========================");
        LOG.debug("userDao:"+userDao);
        LOG.debug("========================");
    }


    @Test
    public void addAndGet() throws ClassNotFoundException, SQLException {
        //---------------------------------------
        //0. 삭제
        //---------------------------------------
        int flag = userDao.delete(user01);
        flag = userDao.delete(user02);
        flag = userDao.delete(user03);

        LOG.debug("========================");
        LOG.debug("deleteFlag:"+flag);
        LOG.debug("========================");

        //---------------------------------------
        //1.추가
        //---------------------------------------
        flag = userDao.add(user01);
        flag = userDao.add(user02);
        flag = userDao.add(user03);

        LOG.debug("========================");
        LOG.debug("addFlag:"+flag);
        LOG.debug("========================");

        //---------------------------------------
        //1.1. 추가 건수 확인
        //---------------------------------------
        assertThat(userDao.getCount("58"),is(3));

        //---------------------------------------
        //2. User정보 조회
        //---------------------------------------
        User vsUser = userDao.get(user01.getU_id());

        assertThat(user01.getU_id(),is(vsUser.getU_id()));
        assertThat(user01.getName(),is(vsUser.getName()));
        assertThat(user01.getPassword(),is(vsUser.getPassword()));
    }


    @After
    public void tearDown() {
        LOG.debug("========================");
        LOG.debug("teardown");
        LOG.debug("========================");
    }

}
