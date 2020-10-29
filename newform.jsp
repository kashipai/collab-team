<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit</title>
</head>
<body>
    <div align="center">
        <h1>New/Edit</h1>
        <form:form action="save" method="post" modelAttribute="emp">
        <table>
                <tr>
                <td>ID:</td>
                <td><form:input path="empid" /></td>
            </tr>
            <tr>
                <td>Name:</td>
                <td><form:input path="name" /></td>
            </tr>


            <tr>
                <td>Telephone:</td>
                <td><form:input path="phone" /></td>
            </tr>
            
            <tr>
                <td>Address:</td>
                <td><form:input path="location" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
        </form:form>
    </div>
</body>
</html>