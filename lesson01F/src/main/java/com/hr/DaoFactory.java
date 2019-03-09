package com.hr;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Application Context / Bean Factory�� ����� ����.
@Configuration
public class DaoFactory {
	
	// Object ������ ����ϴ� IoC (Inversion of Control) Method
	@Bean
	public UserDao userDao() {
		return new UserDao(connectionMaker());
	}
	
	@Bean
	public ConnectionMaker connectionMaker() {
		return new NConnectionMaker();
	}
}
