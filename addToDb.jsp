<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<form method = get action = "retrieve.jsp" >
<%@page import="java.sql.*,java.util.*"%>
<%@page import="java.sql.*,java.sql.*"%>

<%

Connection conn = null;
Statement st = null;

int id = Integer.parseInt(request.getParameter("id"));
String name=request.getParameter("name");
String city_name=request.getParameter("city");
String designation=request.getParameter("designation");
int age = Integer.parseInt(request.getParameter("age"));

try
{
Class.forName("com.mysql.jdbc.Driver");
conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servletexercise","root", "MySql@123");
st = conn.createStatement();

int i = st.executeUpdate("insert into employees(id,name,city,designation,age)values("+id+",'"+name+"','"+city_name+"','"+designation+"',"+age+")");
if(i > 0)
%>
<h2> Data Inserted successfully</h2><br>
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