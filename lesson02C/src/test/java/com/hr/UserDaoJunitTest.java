package com.hr;

import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserDaoJunitTest {

	Logger LOG = Logger.getLogger(this.getClass());
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

		//1. User를 단건 등록 데이타
		User user=new User();  
		user.setU_id("chanhi2000_116");
		user.setName("이찬희");
		user.setPassword("aaabbbccc");

		//2. 삭제
		int flag = userDao.delete(user);
		LOG.debug("========================");
		LOG.debug("deleteFlag:"+flag);
		LOG.debug("========================");

		//98
		flag = userDao.add(user);
		LOG.debug("========================");
		LOG.debug("addFlag:"+flag);
		LOG.debug("========================");
		
		//2. User정보 조회
		User vsUser = userDao.get(user.getU_id());
		
		assertThat(user.getU_id(),is(vsUser.getU_id()));
		assertThat(user.getName(),is(vsUser.getName()));
		assertThat(user.getPassword(),is(vsUser.getPassword()));
		
	}
}
