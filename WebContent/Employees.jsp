<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="java.util.ArrayList,Models.Employee" pageEncoding="ISO-8859-1"%>
<% 
	ArrayList<Employee> aList = (ArrayList<Employee>) request.getAttribute("aList");
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HH-RR Employee</title>
    <script src="assets/js/jsfile.js"></script>
	<link rel="stylesheet" type="text/css" href="assets/css/cssEmployees.css">

</head>
<body>
	<h1> Employee </h1>
	<div id="disp">
        <input type="button" value="Search" onclick="display()">
        <a href="ServletApp?opcion=add"> <input type="button" value="Add new employee"> </a>
    </div>
	<table class="center">
    	<tr>
			<th>Number</th>
			<th>Name</th>
			<th>Job</th>
			<th>Manager</th>
			<th>Hiredate</th>
			<th>Salary</th>
			<th>Commission</th>
			<th>Department</th>
			<th>Delete</th>
			<th>Modify</th>
		</tr>
		<% for(Employee elem: aList) { %>
			<tr>
				<td> <%= elem.getEmpNo() %></td> 
				<td> <%= elem.geteName() %></td>
				<td> <%= elem.getJob() %></td>
				<td> <%= elem.getManager() %></td>
				<td> <%= elem.getHiredate() %></td>
				<td> <%= elem.getSalary() %></td>
				<td> <%= elem.getCommission() %></td>
				<td> <%= elem.getDepNo() %></td>
				<td> <a href='ServletApp?delete=<%= elem.getEmpNo() %>' onclick="return confirmDelete()"> <img src='./assets/img/delete.png'> </a> </td>
				<td> <a href='ServletApp?mod=<%= elem.getEmpNo() %>'> <img src='./assets/img/edit.png'></a> </td>
			</tr>
		<% } %>
	</table>	
</body>
</html>