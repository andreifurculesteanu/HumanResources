<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>  
    <h1>Add new employee</h1>
    <form action="/ServletApp">
        Number: <input type="text" id="empno" size="10">
        Name: <input type="text" id="ename" size="10">
        Job: <input type="text" id="job" size="10">
        Manager: <input type="text" id="mgr" size="10">
        Hiredate (dd/mm/yyyy): <input type="text" id="hiredate" size="10">
        Salary: <input type="text" id="sal" size="10">
        Commision: <input type="text" id="comm" size="10">
        Department: <input type="text" id="deptno" size="10">

        <input type="submit" value="Submit">
    </form>
</body>
</html>