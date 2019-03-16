package com.hr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class UserDao {
	// Bean Configuration에  <property> 태그 안에 넣어줄 것임으로 setter 설정
	private ConnectionMaker connectionMaker;
	public void setConnectionMaker(ConnectionMaker connectionMaker) {
		this.connectionMaker = connectionMaker;
	}
	// CONSTRUCTOR
	public UserDao(ConnectionMaker connectionMaker) {	 this.connectionMaker = connectionMaker;  }
	public UserDao() {}
	
	
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
		Connection connection = connectionMaker.makeConnection();
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
		Connection connection = connectionMaker.makeConnection();
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
}
