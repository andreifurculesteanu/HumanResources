<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="java.util.ArrayList, Objects.Employee" pageEncoding="ISO-8859-1"%>
<% 
	ArrayList<Employee> aList = (ArrayList<Employee>) request.getAttribute("aList");
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HH-RR Employee</title>

	<style>
		
	</style>


</head>
<body>
	<h1> Employee </h1>
	<form action="ServletApp">
		<table>
			<% for(Employee elem: aList) { %>
		      	<tr><td> <%= elem.toString() %> <a href='ServletApp?delete=<%= elem.getEmpNo() %>'> <img src='./img/delete.png'> </a> <a href='ServletApp?mod=<%= elem.getEmpNo() %>'> <img src='./img/edit.png'></a> </td></tr>
		    <% } %>
		</table>
	</form>
</body>
</html>