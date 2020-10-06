<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.*"%>
<form method = get action = "insert.html">

<%
String driver = "com.mysql.jdbc.Driver";

try {
	Class.forName(driver);
} 
catch (ClassNotFoundException e) {
	e.printStackTrace();
}
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>

<!DOCTYPE html>
<html>
<head>
<style>
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
  padding:5px;
}
</style>
</head>

<body>

<center>
<h1 style ="color : crimson">EMPLOYEE DETAILS</h1>

<table>
<tr><th>Id</th><th>Name</th><th>City</th><th>Age</th><th>Designation</th></tr>
<%
try{
	connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/servletexercise","root", "MySql@123");
statement=connection.createStatement();
String sql ="select * from employees";
resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>

<tr>
<td><%=resultSet.getString("id") %></td>
<td><%=resultSet.getString("name") %></td>
<td><%=resultSet.getString("city") %></td>
<td><%=resultSet.getString("age") %></td>
<td><%=resultSet.getString("designation") %></td>
</tr>
<%
}
connection.close();
} catch (SQLException e) {
e.printStackTrace();
}

%>
</table>

<br>
<table><tr><td>
<input type="submit" value="New Entry"> </form></center>
</td>


<td><center>
<form method = "Post" action = "delete.html"><center>
<input type="submit" value="Delete"> </form></td></center>
<td>

<form method = "Post" action = "update.html"><center>
<input type="submit" value="Update"> </center>
</form></td>

</table>
<center>
</body>
</html>