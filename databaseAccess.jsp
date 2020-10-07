<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.sql.*" %>
<%@page import="javax.naming.Context" %>
<%@page import="javax.naming.InitialContext" %>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.io.IOException" %>
<%@page import="javax.naming.NamingException"%>
<%@page import=" javax.sql.DataSource" %>
<%@page import="java.io.PrintWriter"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
     <%
     Context ctx = null;
     Connection con = null;
     Statement stmt = null;
     ResultSet rs = null;
     
     
     try{

		ctx = new InitialContext();
		DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/employee");
		con = ds.getConnection();
		stmt = con.createStatement();
		rs=stmt.executeQuery("select *from employee");
		response.setContentType("text/html");
		out.print("<h1>Display the employee record</h1>");
		out.print("<table border='1'><tr><th>name</th><th>location</th><th>ID</th><th>salary</th><th>DateOfJoining</th></tr>");
		
		while(rs.next()) {
			
		
			out.print("<tr><td>");
			out.println(rs.getString(1));
			out.print("</td>");
			out.print("<td>");
			out.println(rs.getString(2));
			out.print("</td>");
			out.print("<td>");
			out.println(rs.getInt(3));
			out.print("</td>");
			out.print("<td>");
			out.println(rs.getInt(4));
			out.print("</td>");
			out.print("<td>");
			out.println(rs.getDate(5));
		}
		
		
     }catch(NamingException e){
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		finally{
			try {
				out.print("</table>");
				rs.close();
				stmt.close();
				con.close();
				ctx.close();
			} catch (SQLException e) {
				System.out.println("Exception in closing DB resources");
			} catch (NamingException e) {
				System.out.println("Exception in closing Context");
			}
			
		}
	
     %>
</center>


</body>
</html>