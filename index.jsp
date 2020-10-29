<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Students</title>
</head>
<body>
	<div align="center">
		<h1>Student List</h1>
		<h3><a href="new">New Student</a></h3>
		<table border="1" cellpadding="5">
			<tr>
				<th>Roll Number</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email Id</th>
				<th>Action</th>
			</tr>
			<c:forEach var="StudentList" items="${studentList}" varStatus="status">
				<tr>
					<td>${StudentList.rollNo}</td> 
					<td>${StudentList.firstName}</td>
					<td>${StudentList.lastName}</td>
					<td>${StudentList.email}</td>
					<td>
					<a href="delete?rollNo=${StudentList.rollNo}">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>