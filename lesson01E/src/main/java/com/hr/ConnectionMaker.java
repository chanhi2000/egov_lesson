package com.hr;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionMaker {
	/**
	 * Connection ����
	 * @return Connection
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	Connection makeConnection() throws ClassNotFoundException, SQLException;
}