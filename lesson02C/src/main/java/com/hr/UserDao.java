package com.hr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

public class UserDao {
	// Bean Configuration��  <property> �±� �ȿ� �־��� �������� setter ����
	private DataSource dataSource;
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public static Logger LOG = Logger.getLogger(UserDao.class);
	private static final String USER_ID = "U_ID";
	private static final String NAME = "NAME";
	private static final String PASSWORD = "PASSWORD";
	 

	/**
	 * 
	 * @param user
	 *            ������ü
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public int add(User user) throws ClassNotFoundException, SQLException {
		// type "sqlplus SIST_HR/SIST1224@211.238.142.102:1521/orcl" on cmd
		// to validate the database exists.
		Connection connection = dataSource.getConnection();
		LOG.debug("connection:" + connection);

		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO USERS (U_ID,NAME,PASSWORD) VALUES ");
		sb.append("(?,?,?) \n");
		LOG.debug("==============================");
		LOG.debug("Query: \n" + sb.toString());
		LOG.debug("==============================");

		// Query �غ� : Data Binding
		PreparedStatement ps = connection.prepareStatement(sb.toString());
		ps.setString(1, user.getU_id());
		ps.setString(2, user.getName());
		ps.setString(3, user.getPassword());

		int flag = ps.executeUpdate();
		LOG.debug("==============================");
		LOG.debug("flag: " + flag);
		LOG.debug("==============================");

		// Connection ����
		ps.close();
		connection.close();

		return flag;
	}

	public User get(String id) throws ClassNotFoundException, SQLException {
		// type "sqlplus SIST_HR/SIST1224@211.238.142.102:1521/orcl" on cmd
		// to validate the database exists.
		Connection connection = dataSource.getConnection();
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

		if (null == user) throw new NullPointerException();

		LOG.debug("==============================");
		LOG.debug("User: \n" + user.toString());
		LOG.debug("==============================");

		rs.close();
		ps.close();
		connection.close();

		return user;
	}

	public int getCount(String id) throws SQLException {
		Connection connection = dataSource.getConnection();
		LOG.debug("connection:"+connection);
		int cnt = 0;

		StringBuilder sb = new StringBuilder();
		sb.append("SELECT 				\n");
		sb.append("	COUNT(*) cnt		\n");
		sb.append("FROM				 	\n");
		sb.append("	users			 	\n");
		sb.append("WHERE u_id LIKE ? 	\n");
		LOG.debug("==============================");
		LOG.debug("Query: \n" + sb.toString());
		LOG.debug("==============================");

		PreparedStatement ps = connection.prepareStatement(sb.toString());
		ps.setString(1, "%"+id+"%");

		ResultSet rs = ps.executeQuery();
		User user = null;
		if(rs.next()) {
			cnt = rs.getInt("cnt");
		}
		LOG.debug("==============================");
		LOG.debug("cnt:"+cnt);
		LOG.debug("==============================");
		rs.close();
		ps.close();
		connection.close();

		return cnt;
	}

	public int delete(User user) throws ClassNotFoundException, SQLException {
		// type "sqlplus SIST_HR/SIST1224@211.238.142.102:1521/orcl" on cmd
		// to validate the database exists.
		Connection connection = dataSource.getConnection();
		LOG.debug("connection:" + connection);

		StringBuilder sb = new StringBuilder();
		sb.append("DELETE FROM users WHERE u_id = ? ");
		LOG.debug("==============================");
		LOG.debug("Query: \n" + sb.toString());
		LOG.debug("==============================");

		// Query �غ� : Data Binding
		PreparedStatement ps = connection.prepareStatement(sb.toString());
		ps.setString(1, user.getU_id());

		int flag = ps.executeUpdate();
		LOG.debug("==============================");
		LOG.debug("flag: " + flag);
		LOG.debug("==============================");

		// Connection ����
		ps.close();
		connection.close();

		return flag;
	}
}
