package Servlets;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Objects.Employee;
import Utility.Methods;

/**
 * Servlet implementation class ServletApp
 */
@WebServlet("/ServletApp")
public class ServletApp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final String URL = "jdbc:mysql://localhost:3306/empleados";
	public static final String USER = "root";
	public static final String PASS = "root";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletApp() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opcion = request.getParameter("opcion");
		String inserted = " ";
		
		if (opcion != null) {
			if (opcion.equals("add")) {
					request.setAttribute("inserted", inserted);
					/* Las 3 siguientes lineas delegan al JSP pintar el formulario (segun el doGet)*/
					String vista = "/Form.jsp";
			    	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(vista);
			        dispatcher.forward(request, response);
			} else if(opcion.equals("add2")) {
				int empno = Integer.parseInt(request.getParameter("empno"));
				String ename = request.getParameter("ename");
				String job = request.getParameter("job");
				int mgr = Integer.parseInt(request.getParameter("mgr"));
				String hiredate = request.getParameter("hiredate");
				double sal = Double.parseDouble(request.getParameter("sal"));
				double comm = Double.parseDouble(request.getParameter("comm"));
				int depno = Integer.parseInt(request.getParameter("depno"));
				Employee emp = new Employee(empno, ename, job, mgr, hiredate, sal, comm, depno);
				Connection con1 = Methods.createConnection(URL, USER, PASS);
				int value = Methods.addEmployee(con1, emp);
				if (value == 0) {
					inserted = "Employee added correctly";
				} else {
					inserted = "The employee already exists";
				}
				request.setAttribute("inserted", inserted);
				
				/* Las 3 siguientes lineas delegan al JSP pintar el formulario (segun el doGet)*/
				String vista = "/Form.jsp";
		    	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(vista);
		        dispatcher.forward(request, response);
			}
		} else {
			Connection con = Methods.createConnection(URL, USER, PASS);
			ArrayList<Employee> aList = Methods.getAllEmployees(con);
			request.setAttribute("aList", aList);
			
			String delete = request.getParameter("delete");
			if (delete != null) {
				Connection con1 = Methods.createConnection(URL, USER, PASS);
				Methods.deleteEmployee(con1, Integer.parseInt(delete));
				Connection con2 = Methods.createConnection(URL, USER, PASS);
				aList = Methods.getAllEmployees(con2);
				request.setAttribute("aList", aList);
			}
			
			/* Las 3 siguientes lineas delegan al JSP pintar el formulario (segun el doGet)*/
			String vista = "/Employees.jsp";
	    	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(vista);
	        dispatcher.forward(request, response); 	
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
