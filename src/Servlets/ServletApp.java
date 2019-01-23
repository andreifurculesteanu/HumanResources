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

import Models.Employee;
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
		String inserted = "";
		
		if (opcion != null) {
			if (opcion.equals("add")) {
				//go to form.jsp
					request.setAttribute("inserted", inserted);
					/* Las 3 siguientes lineas delegan al JSP pintar el formulario (segun el doGet)*/
					String vista = "/Form.jsp";
			    	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(vista);
			        dispatcher.forward(request, response);
			} else if(opcion.equals("add2")) {
				//once in form.jsp get the parameters, then add the new employee if everything is ok
				String empno1 = request.getParameter("empno");
				String ename = request.getParameter("ename");
				String job = request.getParameter("job");
				String manager = request.getParameter("mgr");
				String hiredate = request.getParameter("hiredate");
				String salary = request.getParameter("sal");
				String commision = request.getParameter("comm");
				String depart = request.getParameter("depno");
				int mgr = 0;
				double comm = 0;
				int depno = 0;
				
				if (empno1.length() > 0 && ename.length() > 0 && job.length() > 0 && hiredate.length() > 0 && salary.length() > 0) {
					int empno = Integer.parseInt(empno1);
					if (manager.length() > 0) {
						mgr = Integer.parseInt(manager);
					}
					double sal = Double.parseDouble(salary);
					if (commision.length() > 0) {
						comm = Double.parseDouble(commision);
					}
					if (depart.length() > 0 ) {
						depno = Integer.parseInt(depart);
					}		
					Employee emp = new Employee(empno, ename, job, mgr, hiredate, sal, comm, depno);
					Connection con1 = Methods.createConnection(URL, USER, PASS);
					int value = Methods.addEmployee(con1, emp);
					if (value == 0) {
						inserted = "Employee added correctly";
					} else {
						inserted = "The employee already exists";
					}
					request.setAttribute("inserted", inserted);
				} else {
					inserted = "Please insert all the requested fields";
					request.setAttribute("inserted", inserted);
				}

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
