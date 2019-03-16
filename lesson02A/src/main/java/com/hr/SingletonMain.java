package com.hr;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonMain {
	
	private static Logger LOG = Logger.getLogger(SingletonMain.class);
	
	public static void main(String[] args) {
		DaoFactory df = new DaoFactory();
		
		UserDao userDao1 = df.userDao();
		UserDao userDao2 = df.userDao();
		LOG.debug("==============================");
		LOG.debug("userDao1: "+userDao1);
		LOG.debug("userDao2: "+userDao2);
		LOG.debug("==============================");	
		//
		// 2019-03-09 16:35:50,396 DEBUG [main] hr.SingletonMain  (SingletonMain.java:14)     - ==============================
		// 2019-03-09 16:35:50,396 DEBUG [main] hr.SingletonMain  (SingletonMain.java:15)     - userDao1: com.hr.UserDao@7cd84586
		// 2019-03-09 16:35:50,396 DEBUG [main] hr.SingletonMain  (SingletonMain.java:16)     - userDao2: com.hr.UserDao@30dae81
		// 2019-03-09 16:35:50,396 DEBUG [main] hr.SingletonMain  (SingletonMain.java:17)     - ==============================
		//
		
		ApplicationContext context
			= new AnnotationConfigApplicationContext(DaoFactory.class);
		
		UserDao userDao3 = context.getBean("userDao", UserDao.class);
		UserDao userDao4 = context.getBean("userDao", UserDao.class);
		LOG.debug("==============================");
		LOG.debug("userDao3: "+userDao3);
		LOG.debug("userDao4: "+userDao4);
		LOG.debug("==============================");
		//
		// 2019-03-09 16:37:27,458 DEBUG [main] hr.SingletonMain  (SingletonMain.java:32)     - ==============================
		// 2019-03-09 16:37:27,458 DEBUG [main] hr.SingletonMain  (SingletonMain.java:33)     - userDao3: com.hr.UserDao@7bb58ca3
		// 2019-03-09 16:37:27,458 DEBUG [main] hr.SingletonMain  (SingletonMain.java:34)     - userDao4: com.hr.UserDao@7bb58ca3
		// 2019-03-09 16:37:27,458 DEBUG [main] hr.SingletonMain  (SingletonMain.java:35)     - ==============================
		//
		
	}
}
