<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body align ="center">
		<strong><%ResourceBundle bundle = ResourceBundle.getBundle("trainingAssignment.MessageBundle", Locale.US); %>
		<%= bundle.getString("greeting") %>  Admin!!!</strong><br><br>
		 <form action="register" >
		 	Enter empID : <input type="text" name = "empId"><br><br>
		 	Enter name : <input type="text" name = "name"><br><br>
		 	Enter location : <input type="text" name = "location"><br><br>
		 	Enter dateOfJoin : <input type="date" name = "dateOfJoin"><br><br>
		 	Enter Designation : <input type = "text" name = "designation"><br><br>
		 	
		 	<input type = "submit">
		 </form>
</body>
</html>