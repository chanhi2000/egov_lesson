package com.hr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
	private static final String USER_ID = "U_ID";
	private static final String NAME = "NAME";
	private static final String PASSWORD = "PASSWORD";
	/**
	 * 
	 * @param user ������ü
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public int add(User user) throws ClassNotFoundException, SQLException {
		// type "sqlplus SIST_HR/SIST1224@211.238.142.102:1521/orcl" on cmd
		// to validate the database exists.
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url 		= "jdbc:oracle:thin:@211.238.142.102:1521:orcl";
		String userID	= "SIST_HR";
		String password = "SIST1224";
		Connection connection = DriverManager.getConnection(url ,userID, password);
		System.out.println("connection:"+connection);
		
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO USERS (U_ID,NAME,PASSWORD) VALUES ");
		sb.append("(?,?,?) \n");
		System.out.println("==============================");
		System.out.println("Query: \n"+sb.toString());
		System.out.println("==============================");
	
		
		// Query �غ� : Data Binding
		PreparedStatement ps = connection.prepareStatement(sb.toString());
		ps.setString(1, user.getU_id());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPassword());
		
		int flag = ps.executeUpdate();
		System.out.println("==============================");
		System.out.println("flag: "+flag);
		System.out.println("==============================");
		
		// Connection ����
		ps.close();
		connection.close();
		
		return flag;
	}
	
	public User get(String id) throws ClassNotFoundException, SQLException {
		// type "sqlplus SIST_HR/SIST1224@211.238.142.102:1521/orcl" on cmd
		// to validate the database exists.
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url 		= "jdbc:oracle:thin:@211.238.142.102:1521:orcl";
		String userID	= "SIST_HR";
		String password = "SIST1224";
		Connection connection = DriverManager.getConnection(url ,userID, password);
		System.out.println("connection:"+connection);
		
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT 			\n");
		sb.append("	u_id,			\n");
		sb.append("	name,			\n");
		sb.append("	password		\n");
		sb.append("FROM				\n");
		sb.append("	users			\n");
		sb.append("WHERE u_id = ?	\n");
		System.out.println("==============================");
		System.out.println("Query: \n"+sb.toString());
		System.out.println("==============================");
	
		PreparedStatement ps = connection.prepareStatement(sb.toString());
		ps.setString(1,  id);
		
		ResultSet rs = ps.executeQuery();
		User user = null;
		if (rs.next()) {
			user = new User();
			user.setU_id(rs.getString(USER_ID));
			user.setName(rs.getString(NAME));
			user.setPassword(rs.getString(PASSWORD));
		}
		System.out.println("==============================");
		System.out.println("User: \n"+user.toString());
		System.out.println("==============================");
		
		rs.close();
		ps.close();
		connection.close();
		
		return user;
	}
	
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
		/*
		 * User �ܰ� ���
		 */
		UserDao userDao = new UserDao();
		User user = new User();
		user.setU_id("chanhi2000_116");
		user.setName("������");
		user.setPassword("aaabbbccc");
		
		int flag = userDao.add(user);
		System.out.println("==============================");
		System.out.println("isInsertSuccessful: "+flag);
		System.out.println("==============================");
		
		/**
		 * User �ܰ� ����
		 */
		User vsUser = userDao.get(user.getU_id());
		
		/**
		 * ��ϵ� User�� ��ȸ�� User�� �� (���ƾ� ����)
		 */
		if (user.getU_id().equals(vsUser.getU_id()) && 
				user.getName().equals(vsUser.getName()) &&
				user.getPassword().equals(vsUser.getPassword())){
			System.out.println("==============================");
			System.out.println("successfully locate the newly added user");
			System.out.println("==============================");
		} else {
			System.out.println("==============================");
			System.out.println("failed to locate the newly added user");
			System.out.println("==============================");
		}
		
	}
}
