
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.*" %>
<%@page import="javax.naming.*" %>
<%@page import ="javax.sql.DataSource"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Database</title>
</head>

<body>

<h1>Employee Record</h1>
<table border="1">
<tr>
<td>Employee Id</td>
<td>First Name</td>
<td>Last Name</td>
<td>Age</td>
</tr>

<%

int EmpId = Integer.parseInt(request.getParameter("EmpId"));
String FirstName=request.getParameter("FirstName");
String LastName=request.getParameter("LastName");
int age = Integer.parseInt(request.getParameter("age"));
Connection con = null;
Statement stmt = null;
Context envContext = null;
try{
envContext = new InitialContext();
Context initContext = (Context) envContext.lookup("java:/comp/env");
DataSource ds = (DataSource) initContext.lookup("jdbc/Database1");
			
con = ds.getConnection();
stmt = con.createStatement();

stmt.executeUpdate("INSERT INTO Database1.Employee(EmpId,FirstName,LastName,age) VALUES("+EmpId+",'"+FirstName+"','"+LastName+"',"+age+");");

String sql ="SELECT * FROM Database1.Employee";
ResultSet rs = stmt.executeQuery(sql);
while(rs.next()){
%>
<tr>
<td><%=rs.getString("EmpId") %></td>
<td><%=rs.getString("FirstName") %></td>
<td><%=rs.getString("LastName") %></td>
<td><%=rs.getString("age") %></td>
</tr>
<%
}
rs.close();
stmt.close();
con.close();
} catch (SQLException se) {
se.printStackTrace();
} catch (NamingException e) {
e.printStackTrace();
} catch (Exception e) {
e.printStackTrace();
} finally {
try {
	if (stmt != null)
		stmt.close();
} catch (SQLException se2) {
}
try {
	if (con != null)
		con.close();
} catch (SQLException se) {
	se.printStackTrace();
}
}

%>
</table>
</body>
</html>


