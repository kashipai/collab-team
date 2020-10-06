<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<form method = get action = "retrieve.jsp">
<%@page import="java.sql.*,java.util.*"%>
<%@page import="java.sql.*,java.sql.*"%>

<%
Connection conn = null;
Statement st = null;


int id = Integer.parseInt(request.getParameter("id"));

try
{
Class.forName("com.mysql.jdbc.Driver");

conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servletexercise","root", "MySql@123");
st=conn.createStatement();

int i = st.executeUpdate("delete from employees where id = "+id);
if(i > 0)
%>
<h2> Data Deleted successfully</h2><br>
<%

}
catch(SQLException e)
{
out.println(e);

e.printStackTrace();
}
catch(ClassNotFoundException ce)
{
	ce.printStackTrace();
}
finally
{
	conn.close();
	st.close();
}
%>

<input type="submit" value="View Changes">
</form>