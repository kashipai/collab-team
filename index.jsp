<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Home</title>
</head>
<body>
<div align="center">
     <h1>Employee List</h1>
     <h3><a href="new">New Employee</a></h3>
       <table border="1" cellpadding="5">
        <tr>
          <th>Name</th>
          <th>location</th>
          <th>id</th>
          <th>salary</th>
          <th>Action</th>
        </tr> 
        <c:forEach items="${listEmployee}" var="employee" varStatus="status">
        <tr>
          
          <td> ${status.index +1 }</td>
           <td>${employee.name}</td>
           <td>${employee.location}</td>
           <td> ${employee.id}</td>
           <td>${employee.salary}</td>
           <td> 
           <a href="edit?id=${employee.id}">Edit</a>
            &nbsp;&nbsp;
            <a href="delete?id=${employee.id}">Edit</a>
            
           </td>
         
        </tr>
        </c:forEach>
       </table>
</div>

</body>
</html>