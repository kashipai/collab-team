<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Customer</title>
</head>
<body>
<div align="center">
    <h1>Customer List</h1>
    <h3><a href="newform">Add Customer</a></h3>
    <table border="1">
        <th>ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email ID</th>

        <c:forEach var="customer" items="${list}">
            <tr>
                <td>${customer.id}</td>
                <td>${customer.firstname}</td>
                <td>${customer.lastname}</td>
                <td>${customer.email}</td>
                <td>
                    <a href="delete?id=${customer.id}">Delete</a>
                </td>

            </tr>
        </c:forEach>
    </table>
</div>
</body>

</html>
