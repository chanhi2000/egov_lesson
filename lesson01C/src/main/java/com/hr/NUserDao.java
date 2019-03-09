package com.hr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class NUserDao extends UserDao {

	@Override
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@211.238.142.102:1521:orcl";
		String userID = "SIST_HR";
		String password = "SIST1224";
		return DriverManager.getConnection(url, userID, password);
	}

	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		/*
		 * User �ܰ� ���
		 */
		UserDao userDao = new NUserDao();
		User user = new User();
		user.setU_id("chanhi2000_116");
		user.setName("������");
		user.setPassword("aaabbbccc");

		int flag = userDao.add(user);
		LOG.debug("==============================");
		LOG.debug("isInsertSuccessful: " + flag);
		LOG.debug("==============================");

		/**
		 * User �ܰ� ����
		 */
		User vsUser = userDao.get(user.getU_id());

		/**
		 * ��ϵ� User�� ��ȸ�� User�� �� (���ƾ� ����)
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
