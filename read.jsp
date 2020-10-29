<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p><strong>Employee List is Here | <a href="add.jsp">Click for add</a></strong></p>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Name</th>			
		</tr>
		<c:forEach var="emp" items="${listEmployee}">
			<tr>
				<td>${emp.id}</td>
				<td>${emp.name}</td>				
				<td>| <a href="delete/<c:out value='${emp.id}'/>">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>