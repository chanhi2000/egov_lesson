package com.hr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SimpleConnectionMaker {
	public Connection makeConnection() throws ClassNotFoundException, SQLException  {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@211.238.142.102:1521:orcl";
		String userID = "SIST_HR";
		String password = "SIST1224";
		return DriverManager.getConnection(url, userID, password);
	}
}
