package com.hr;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)       // method execute order by name ascending
public class UserDaoJUnitTest08 {
    private Logger LOG = Logger.getLogger(this.getClass());

    @Autowired
    private ApplicationContext context;

    @Autowired
    private UserDao userDao;

    private User user01;
    private User user02;
    private User user03;

    @Before
    public void setUp() {
        LOG.debug("========================>");
        LOG.debug("setUp");
        LOG.debug("========================>");
        // Test Data
        user01=new User("c01_58", "이찬희", "1234");
        user02=new User("c02_58", "이찬희", "1234");
        user03=new User("c03_58", "이찬희", "1234");
    }

    @Test(expected = NullPointerException.class)
    @Ignore
    public void getUserFailure() throws ClassNotFoundException, SQLException {
        //---------------------------------------
        //0.삭제.
        //---------------------------------------
        int flag = userDao.delete(user01);
        flag = userDao.delete(user02);
        flag = userDao.delete(user03);
        LOG.debug("========================");
        LOG.debug("flag:"+flag);
        LOG.debug("========================");

        userDao.get("unknown_id");
    
    }

    @Test
    @Ignore
    public void test01() {
        LOG.debug("========================");
        LOG.debug("test01:");
        LOG.debug("========================");
    }


    @Test
    public void addAndGet() throws ClassNotFoundException, SQLException {


        //---------------------------------------
        //0.삭제.
        //---------------------------------------
        int flag = userDao.delete(user01);
        flag = userDao.delete(user02);
        flag = userDao.delete(user03);
        LOG.debug("========================");
        LOG.debug("flag:"+flag);
        LOG.debug("========================");

        //---------------------------------------
        //1.추가
        //---------------------------------------
        flag = userDao.add(user01);
        LOG.debug("flag:"+flag);
        flag = userDao.add(user02);
        flag = userDao.add(user03);

        //---------------------------------------
        //1.1. 추가 건수 확인
        //---------------------------------------
        assertThat(userDao.getCount("58"),is(3));


        //2. User정보 단건조회
        User vsUser = userDao.get(user01.getU_id());

        assertThat(user01.getU_id(),is(vsUser.getU_id()));
        assertThat(user01.getName(),is(vsUser.getName()));
        assertThat(user01.getPassword(),is(vsUser.getPassword()));
    }
}
