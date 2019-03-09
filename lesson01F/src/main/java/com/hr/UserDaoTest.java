package com.hr;

import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserDaoTest {
	public static Logger LOG = Logger.getLogger(UserDaoTest.class);
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		ApplicationContext context 
			= new AnnotationConfigApplicationContext(DaoFactory.class);
		
		/*
		 * User 단건 등록
		 */
		UserDao userDao = context.getBean("userDao", UserDao.class);
		LOG.debug("==============================");
		LOG.debug("userDao: " + userDao.toString());
		LOG.debug("==============================");
		
		User user = new User();
		user.setU_id("chanhi2000_116");
		user.setName("이찬희");
		user.setPassword("aaabbbccc");

		int flag = userDao.add(user);
		LOG.debug("==============================");
		LOG.debug("isInsertSuccessful: " + flag);
		LOG.debug("==============================");

		/**
		 * User 단건 조희
		 */
		User vsUser = userDao.get(user.getU_id());

		/**
		 * 등록된 User와 조회한 User를 비교 (같아야 성공)
		 */
		if (user.getU_id().equals(vsUser.getU_id()) && user.getName().equals(vsUser.getName())
				&& user.getPassword().equals(vsUser.getPassword())) {
			LOG.debug("==============================");
			LOG.debug("successfully locate the newly added user");
			LOG.debug("==============================");
		} else {
			LOG.debug("==============================");
			LOG.debug("failed to locate the newly added user");
			LOG.debug("==============================");
		}
	}
}
