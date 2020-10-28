<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New/Edit Employee</title>
</head>
<body>
   <div align="center">
   <h1>New/Edit Employee</h1>
   <form:form action="save" method="post" modelAttribute="employee">
   <table cellpadding="5">
   <form:hidden path="id"/>
   <tr>
     <td>Name:</td>
     <td><form:input path="name"/></td>

   </tr>
    <tr>
     <td>Location:</td>
     <td><form:input path="location"/></td>

   </tr>
   <tr>
     <td>ID:</td>
     <td><form:input path="id"/></td>

   </tr>
   <tr>
     <td>Salary:</td>
     <td><form:input path="salary"/></td>

   </tr>
   <tr>
   <td colspan="2" align="center"><input type="submit" value="Save"/></td>
   </tr>
   </table>
   
   </form:form>
   </div>

</body>
</html>