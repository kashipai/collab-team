<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>xyz</title>
    </head>
    <body>
        <div align="center">
            <h1>Employee List</h1>
            <h3><a href="newform">New emp</a></h3>
            <table border="1">
                <th>employeeid</th>
                <th>Name</th>            
                <th>Telephone</th>
                <th>Address</th>
                <th>Action</th>
                 
                <c:forEach var="emp" items="${list}">
                <tr>
                    <td>${emp.empid}</td>
                    <td>${emp.name}</td>
                    <td>${emp.phone}</td>
                    <td>${emp.location}</td>
                    <td>
                        <a href="edit?empid=${emp.empid}">Edit</a>
                       
                        <a href="delete?empid=${emp.empid}">Delete</a>
                    </td>
                             
                </tr>
                </c:forEach>             
            </table>
        </div>
    </body>
</html>