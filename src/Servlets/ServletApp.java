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

		Connection con = Methods.createConnection(URL, USER, PASS);
		ArrayList<Employee> aList = Methods.getAllEmployees(con);
		request.setAttribute("aList", aList);
		
		String delete = request.getParameter("delete");
		if (delete != null) {
			Methods.deleteEmployee(con, Integer.parseInt(delete));
		}
		
		/* Las 3 siguientes lineas delegan al JSP pintar el formulario (segun el doGet)*/
		String vista = "/Employees.jsp";
    	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(vista);
        dispatcher.forward(request, response); 	
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
