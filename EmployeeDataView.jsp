<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body align = "center">
	<strong>Employee Data sorted according to Location</strong>
	<table border="1" align = "center">
	    <tr>
	    	<th>EmpID</th>
	    	<th>Name</th>
	    	<th>Location</th>
	    	<th>DateOfJoin</th>
	    	<th>Designation</th>
	    </tr>
		<%ResultSet  rs = (ResultSet)request.getAttribute("resultSet");
		while(rs.next()){ %>
		 <tr>
			 <td><%=rs.getString(1) %></td>
			 <td><%=rs.getString(2) %></td>
			 <td><%=rs.getString(3) %></td>
			 <td><%=rs.getString(4) %></td>
			 <td><%=rs.getString(5) %></td>
	
		 </tr>
			
		<%} %>
	 </table>
</body>
</html>