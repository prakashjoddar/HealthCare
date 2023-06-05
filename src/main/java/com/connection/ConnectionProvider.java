package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.constant.Constants;

public class ConnectionProvider {
	public static Connection getConnection() {

		Connection connection = null;

		try {
			Class.forName(Constants.Mysql_Driver);
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/maximus", Constants.userId,
					Constants.password);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;

	}
}

//this is depedency injection
// used to make single copy of connection