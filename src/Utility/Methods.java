package Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Objects.Employee;

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
	
	/**
	 * 
	 * @param connection
	 * @return
	 */
	public static ArrayList getAllEmployees(Connection connection) {
		PreparedStatement preparedStatement = null;
		ArrayList<Employee> aList = new ArrayList<Employee>();
		try {
			preparedStatement = connection.prepareStatement("select * from emp");
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				Employee emp = new Employee(rs.getInt("empno"), rs.getString("ename"), rs.getString("job"), 
											rs.getInt("mgr"), rs.getString("hiredate"), rs.getDouble("sal"), 
											rs.getDouble("comm"), rs.getInt("deptno"));
				aList.add(emp);
			}
			preparedStatement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return aList;
	}
	
	
	public static void deteleEmployee(Connection connection, int empno) {
		PreparedStatement preparedStatement = null;
		
		try {
			preparedStatement = connection.prepareStatement("Delete from emp where empNo = ?");
			preparedStatement.setInt(1, empno);	
			preparedStatement.executeUpdate();
			preparedStatement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
}
