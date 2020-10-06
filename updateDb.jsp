<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<form method = get action = "retrieve.jsp">
<%@page import="java.sql.*,java.util.*"%>
<%@page import="java.sql.*,java.sql.*"%>

<%
Connection conn = null;
Statement st = null;

int uId = Integer.parseInt(request.getParameter("uId"));

String name=request.getParameter("name");
String city = request.getParameter("city");
String designation=request.getParameter("designation");
int age = Integer.parseInt(request.getParameter("age"));

try
{
Class.forName("com.mysql.jdbc.Driver");
 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servletexercise","root", "MySql@123");
 st = conn.createStatement();

int i=st.executeUpdate("update employees set name = '"+name+"', city = '"+city+"',designation = '"+designation+"',age = "+age+" where id = "+uId);
if(i > 0)

%>
<h2>Data has been successfully updated</h2><br>
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