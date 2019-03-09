package com.hr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class UserDao {
	private SimpleConnectionMaker simpleConnectionMaker;
	public UserDao(SimpleConnectionMaker  connectionMaker) {	 this.simpleConnectionMaker = connectionMaker;  }
	public UserDao() {  this(new SimpleConnectionMaker());  }
	
	public static Logger LOG = Logger.getLogger(UserDao.class);
	private static final String USER_ID = "U_ID";
	private static final String NAME = "NAME";
	private static final String PASSWORD = "PASSWORD";
	 

	/**
	 * 
	 * @param user
	 *            유저객체
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public int add(User user) throws ClassNotFoundException, SQLException {
		// type "sqlplus SIST_HR/SIST1224@211.238.142.102:1521/orcl" on cmd
		// to validate the database exists.
		Connection connection = simpleConnectionMaker.makeConnection();
		LOG.debug("connection:" + connection);

		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO USERS (U_ID,NAME,PASSWORD) VALUES ");
		sb.append("(?,?,?) \n");
		LOG.debug("==============================");
		LOG.debug("Query: \n" + sb.toString());
		LOG.debug("==============================");

		// Query 준비 : Data Binding
		PreparedStatement ps = connection.prepareStatement(sb.toString());
		ps.setString(1, user.getU_id());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPassword());

		int flag = ps.executeUpdate();
		LOG.debug("==============================");
		LOG.debug("flag: " + flag);
		LOG.debug("==============================");

		// Connection 종료
		ps.close();
		connection.close();

		return flag;
	}

	public User get(String id) throws ClassNotFoundException, SQLException {
		// type "sqlplus SIST_HR/SIST1224@211.238.142.102:1521/orcl" on cmd
		// to validate the database exists.
		Connection connection = simpleConnectionMaker.makeConnection();
		LOG.debug("connection:" + connection);

		StringBuilder sb = new StringBuilder();
		sb.append("SELECT 			\n");
		sb.append("	u_id,			\n");
		sb.append("	name,			\n");
		sb.append("	password		\n");
		sb.append("FROM				\n");
		sb.append("	users			\n");
		sb.append("WHERE u_id = ?	\n");
		LOG.debug("==============================");
		LOG.debug("Query: \n" + sb.toString());
		LOG.debug("==============================");

		PreparedStatement ps = connection.prepareStatement(sb.toString());
		ps.setString(1, id);

		ResultSet rs = ps.executeQuery();
		User user = null;
		if (rs.next()) {
			user = new User();
			user.setU_id(rs.getString(USER_ID));
			user.setName(rs.getString(NAME));
			user.setPassword(rs.getString(PASSWORD));
		}
		LOG.debug("==============================");
		LOG.debug("User: \n" + user.toString());
		LOG.debug("==============================");

		rs.close();
		ps.close();
		connection.close();

		return user;
	}
	
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		/*
		 * User 단건 등록
		 */
		UserDao userDao = new UserDao();
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
