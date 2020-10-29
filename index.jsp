<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>BOOK</title>
    </head>
    <body>
        <div align="center">
            <h1>Employee List</h1>
            <h3><a href="newform">Add Book</a></h3>
            <table border="1">
                <th>Book id</th>
                <th>Book Name</th>            
                <th>Author</th>
                <th>Cost</th>
                 
                <c:forEach var="book" items="${list}">
                <tr>
                    <td>${book.id}</td>
                    <td>${book.name}</td>
                    <td>${book.author}</td>
                    <td>${book.cost}</td>
                    <td>
                        <a href="edit">Edit</a>
                       
                        <a href="delete?id=${book.id}">Delete</a>
                    </td>
                             
                </tr>
                </c:forEach>             
            </table>
        </div>
    </body>

</html>