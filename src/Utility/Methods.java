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
	
	
	public static ArrayList getAllEmployees(Connection connection) {
		PreparedStatement preparedStatement = null;
		ArrayList<Employee> aList = new ArrayList<Employee>();
		try {
			preparedStatement = connection.prepareStatement("select * from emp");
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				Employee emp = new Employee(0, 0, 0, null, null, null, 0, 0);
				
				emp.setEmpNo(rs.getInt("empno"));
				emp.seteName(rs.getString("ename"));
				emp.setJob(rs.getString("job"));
				emp.setManager(rs.getInt("mgr"));
				emp.setHiredate(rs.getString("hiredate"));
				emp.setSalary(rs.getLong("sal"));
				emp.setCommission(rs.getDouble("comm"));
				emp.setDepNo(rs.getInt("deptno"));
				
				aList.add(emp);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return aList;
	}
	
	
}
