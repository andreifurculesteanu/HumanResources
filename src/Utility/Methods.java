package Utility;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import Models.Employee;

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
	} // end getAllEmployees()
	
	
	public static void deleteEmployee(Connection connection, int empno) {
		PreparedStatement preparedStatement = null;
		
		try {
			preparedStatement = connection.prepareStatement("delete from emp where empno = ?");
			preparedStatement.setInt(1, empno);	
			preparedStatement.executeUpdate();
			preparedStatement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} // end deleteEmployee()
	
	
	public static int addEmployee(Connection connection, Employee emp) {
		PreparedStatement preparedStatement = null;
		PreparedStatement psCheck = null;
		int val = 0;
		String hiredate;
		try {
			psCheck = connection.prepareStatement("Select empno from emp where empno = ?");
			psCheck.setInt(1, emp.getEmpNo() );
			ResultSet rowsAffected = psCheck.executeQuery();
			while (rowsAffected.next()) {
				val++;
			}
			if (val == 0) {
				preparedStatement = connection.prepareStatement("Insert into emp values (?, ?, ?, ?, STR_TO_DATE('?', '%d-%m-%Y'), ?, ?, ?)");
				preparedStatement.setInt(1, emp.getEmpNo());
				preparedStatement.setString(2, emp.geteName());
				preparedStatement.setString(3, emp.getJob());
				preparedStatement.setInt(4, emp.getManager());
				
				  	hiredate = emp.getHiredate();
				 	System.out.println(hiredate);
				 	preparedStatement.setString(5, hiredate);
				/*
				String patron = "dd-MM-yyyy";
				SimpleDateFormat sdf = new SimpleDateFormat(patron);
				java.util.Date fechaAlta;
				try {
					fechaAlta = sdf.parse(emp.getHiredate());
					preparedStatement.setDate(5, (Date) fechaAlta);
				} catch (ParseException e) {
					preparedStatement.setNull(5, java.sql.Types.DATE);
				}
				*/
				preparedStatement.setDouble(6, emp.getSalary());
				preparedStatement.setDouble(7, emp.getCommission());
				preparedStatement.setInt(8, emp.getDepNo());
				preparedStatement.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getErrorCode());
			System.out.println(e.getSQLState());
			
		}
		return val;
	} // end addEmployee()
	
	
	
	public static void modifyEmployee(Connection connection, Employee emp) {
		PreparedStatement ps = null;
		 try {
			ps = connection.prepareStatement("update emp set ename='" + emp.geteName() + "', job='" + emp.getJob() + "', mgr=" + emp.getManager() + 
															", hiredate=str_to_date('" + emp.getHiredate() + "', %Y-%m-%d'), sal=" + emp.getSalary() + 
															", comm=" + emp.getCommission() + ", deptno=" + emp.getDepNo() + 
											"where empno=" + emp.getEmpNo());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
