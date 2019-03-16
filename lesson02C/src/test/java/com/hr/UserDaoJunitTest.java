package com.hr;

import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserDaoJUnitTest {

    private Logger LOG = Logger.getLogger(this.getClass());
	@Test
	public void addAndGet() throws ClassNotFoundException, SQLException {
		LOG.debug("JUnit");
		ApplicationContext context 
		= new GenericXmlApplicationContext("/applicationContext.xml");
		LOG.debug("========================");
		LOG.debug("context:"+context);
		LOG.debug("========================");
		
		UserDao userDao=context.getBean("userDao", UserDao.class);
		LOG.debug("========================");
		LOG.debug("userDao:"+userDao);
		LOG.debug("========================");

		//---------------------------------------
		//1. User를 단건 등록 데이타
		//---------------------------------------
		User user01=new User("c01_58", "이찬희", "1234");
		User user02=new User("c02_58", "이찬희", "1234");
		User user03=new User("c03_58", "이찬희", "1234");

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
}
