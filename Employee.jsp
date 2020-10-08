<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.naming.*"%>
<%@page import="javax.sql.DataSource"%>
<%
	Connection conn = null;
Statement stmt = null;
Context envContext = null;
%>
<h2 align="center">
	<font><strong>Employee Record using JSP</strong></font>
</h2>
<table align="center" cellpadding="5" cellspacing="5" border="1">
	<tr>

	</tr>
	<tr bgcolor="#A52A2A">
		<td><b>Employee Id</b></td>
		<td><b>First Name</b></td>
		<td><b>Last Name</b></td>
		<td><b>Salary</b></td>
		<td><b>Age</b></td>
	</tr>
	<%
		try {
		envContext = new InitialContext();
		Context initContext = (Context) envContext.lookup("java:/comp/env");
		DataSource ds = (DataSource) initContext.lookup("jdbc/database2");

		Connection con = ds.getConnection();

		Statement stmt1 = con.createStatement();
		String query = "SELECT * FROM database2.emptable";
		ResultSet rs = stmt1.executeQuery(query);

		response.setContentType("text/html");
		while (rs.next()) {
	%>
	<tr bgcolor="#DEB887">

		<td><%=rs.getString("EmpId")%></td>
		<td><%=rs.getString("FirstName")%></td>
		<td><%=rs.getString("LastName")%></td>
		<td><%=rs.getInt("Salary")%></td>
		<td><%=rs.getInt("Age")%></td>

	</tr>

	<%
		}
	rs.close();
	} catch (Exception e) {
	e.printStackTrace();
	} finally {
	if (stmt != null)
	stmt.close();

	if (conn != null)
	conn.close();

	}
	%>
</table>