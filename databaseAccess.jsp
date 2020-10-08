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
<%@page import="java.util.ResourceBundle" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
     <%
     ResourceBundle resourceBundle=ResourceBundle.getBundle("databasefetchingjsp.i18n.demobundle_de_DE",request.getLocale());
     Context ctx = null;
     Connection con = null;
     Statement stmt = null;
     ResultSet rs = null;
     response.setContentType("text/html");
		out.print("<h1>");
		out.print(resourceBundle.getString("Employee Record"));
		out.print("</h1>");
		
		out.print("<table border='1'>");
		out.print("<tr>");
		out.print("<th>");
		out.print(resourceBundle.getString("name"));
		out.print("</th>");
		out.print("<th>");
		out.print(resourceBundle.getString("location"));
		out.print("</th>");
		out.print("<th>");
		out.print(resourceBundle.getString("ID"));
		out.print("</th>");
		out.print("<th>");
		out.print(resourceBundle.getString("salary"));
		out.print("</th>");
		out.print("</tr>");
		
     
     try{

		ctx = new InitialContext();
		DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/employee");
		con = ds.getConnection();
		stmt = con.createStatement();
		rs=stmt.executeQuery("select *from employee");
		
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