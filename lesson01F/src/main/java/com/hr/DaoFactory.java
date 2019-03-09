package com.hr;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Application Context / Bean Factory가 사용할 정보.
@Configuration
public class DaoFactory {
	
	// Object 생성을 담당하는 IoC (Inversion of Control) Method
	@Bean
	public UserDao userDao() {
		return new UserDao(connectionMaker());
	}
	
	@Bean
	public ConnectionMaker connectionMaker() {
		return new NConnectionMaker();
	}
}
