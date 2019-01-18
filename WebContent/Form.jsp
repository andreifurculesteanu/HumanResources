<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	String inserted = (String) request.getParameter("inserted");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>  
    <div class="w3-container w3-blue">
  	     <h2>Add new employee</h2>
    </div>
    <div>
    <% if(inserted != null){ %>
    		<%=inserted %> 
    <% }%>
    </div>
    <form class="w3-container" action="ServletApp">
            <input type="hidden"  name="opcion" value="add2">
            <p>
            <label>*Number</label>
            <input class="w3-input" type="text" placeholder="requested" name="empno"></p>
            <p>
            <label>*Name</label>
            <input class="w3-input" type="text" placeholder="requested" name="ename"></p>
            <p>
            <label>*Job</label>
            <input class="w3-input" type="text" placeholder="requested" name="job"></p>
            <p>
            <label>Manager</label>
            <input class="w3-input" type="text" name="mgr"></p>
            <p>
            <label>*Hiredate</label>
            <input class="w3-input" type="text" placeholder="dd/mm/yyyy - requested" name="hiredate"></p>
            <p>
            <label>*Salary</label>
            <input class="w3-input" type="text" placeholder="requested" name="sal"></p>
            <p>
            <label>Commision</label>
            <input class="w3-input" type="text" name="comm"></p>
            <p>
            <label>Department</label>
            <input class="w3-input" type="text" name="depno"></p>
            
            <input type="submit" class="w3-btn w3-blue" value="Register">
            <button class="w3-btn w3-blue" onclick="this.disabled=true; location.href = 'http://localhost:8080/HumanResources/ServletApp';">Home</button>
    </form>
</body>
</html>