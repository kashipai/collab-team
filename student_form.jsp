<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student form</title>
</head>
<body>
	<div align="center">
		<h1>New Student</h1>
		<form:form action="save" method="post" modelAttribute="student">
			<table>
				<tr>
					<td>Roll Number:</td>
					<td><form:input path="rollNo" /></td>
				</tr>
				<tr>
					<td>First Name:</td>
					<td><form:input path="firstName" /></td>
				</tr>
				<tr>
					<td>Last Name:</td>
					<td><form:input path="lastName" /></td>
				</tr>
				<tr>
					<td>Email Id:</td>
					<td><form:input path="email" /></td>
				</tr>
				<tr>
				<td colspan="2"><input type="submit" value="Save"/></td>
				</tr>
			</table>
		</form:form>
	</div>

</body>
</html>