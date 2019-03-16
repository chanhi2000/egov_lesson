package com.hr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
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

	private static final String QRY_DELETE = "DELETE FROM users WHERE u_id = ? ";
	private static final String QRY_INSERT = "INSERT INTO USERS (U_ID,NAME,PASSWORD) VALUES (?,?,?) ";
	private static final String QRY_SELECT_ID = "SELECT u_id, name, password FROM users WHERE u_id = ?";
	private static final String QRY_COUNT = "SELECT COUNT(*) cnt FROM users WHERE u_id LIKE ? ";

	/**
	 * 
	 * @param user
	 *            ������ü
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public int add(User user) throws ClassNotFoundException, SQLException {
		int flag = 0;
		flag = jdbcContextWithStrategy(new StatementStrategy() {
			@Override
			public PreparedStatement makeStatement(Connection c, User user) throws SQLException {
				StringBuilder sb = new StringBuilder();
				sb.append(QRY_INSERT);
				LOG.debug("==============================");
				LOG.debug("Query: \n" + sb.toString());
				LOG.debug("==============================");

				// Query �غ� : Data Binding
				PreparedStatement ps = c.prepareStatement(sb.toString());
				ps.setString(1, user.getU_id());
				ps.setString(2, user.getName());
				ps.setString(3, user.getPassword());

				return ps;
			}
		}, user);
		return flag;
	}

	public User get(String id) throws ClassNotFoundException, SQLException {
		// type "sqlplus SIST_HR/SIST1224@211.238.142.102:1521/orcl" on cmd
		// to validate the database exists.
		Connection connection = dataSource.getConnection();
		LOG.debug("connection:" + connection);

		StringBuilder sb = new StringBuilder();
		sb.append(QRY_SELECT_ID);
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
		sb.append(QRY_COUNT);
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

	/**
	 * 사용자 삭제
	 * @param user
	 * @return 0보다 크면 성공, 그렇지 않음 실패
	 * @throws SQLException
	 */
	public int delete(final User user) throws SQLException {
		int flag = 0;
		flag = jdbcContextWithStrategy(new StatementStrategy() {
			@Override
			public PreparedStatement makeStatement(Connection c, User user) throws SQLException {
				PreparedStatement ps = null;

				StringBuilder sb = new StringBuilder();
				sb.append(QRY_DELETE);
				LOG.debug("==============================");
				LOG.debug("User: \n" + user.toString());
				LOG.debug("Query: \n" + sb.toString());
				LOG.debug("==============================");

				// Query �غ� : Data Binding
				ps = c.prepareStatement(sb.toString());
				ps.setString(1, user.getU_id());

				return ps;
			}
		}, user);
		return flag;
	}


	private int jdbcContextWithStrategy(StatementStrategy strategy, User user) throws SQLException {
		// type "sqlplus SIST_HR/SIST1224@211.238.142.102:1521/orcl" on cmd
		// to validate the database exists.
		Connection connection = null;
		PreparedStatement ps = null;
		int flag = 0;
		try {
			connection = dataSource.getConnection();
			LOG.debug("connection:" + connection);

			ps = strategy.makeStatement(connection, user);
			ps.setString(1, user.getU_id());

			flag = ps.executeUpdate();
			LOG.debug("==============================");
			LOG.debug("flag: " + flag);
			LOG.debug("==============================");

		} catch (SQLException e) {
			throw e;
		} finally {
			// Connection ����
			if (null != ps)
				try { ps.close(); }
				catch (SQLException e) { }
			if (null != connection)
				try { connection.close(); }
				catch (SQLException e) { }
		}
		return flag;
	}

}
