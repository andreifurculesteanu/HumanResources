package Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Methods {
	
	/**
	 * 
	 * @param url
	 * @param usuario
	 * @param pass
	 * @return
	 */
	public static Connection createConnection(String url, String usuario, String pass) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url, usuario, pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	
	public static void getAllEmployees(Connection connection) {
		PreparedStatement preparedStatement = null;
		String selectSQL = "select * from emp";
		try {
			preparedStatement = connection.prepareStatement(selectSQL);
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
	}
	
	
}
