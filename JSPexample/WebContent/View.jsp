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
<title>employee record</title>
</head>
<body>
<center>
<%
if(request.getParameter("button1") != null) {
	
	
		    final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		     final String DB_URL="jdbc:mysql://localhost/test?characterEncoding=latin1";

		    //  Database credentials
		     final String USER = "root";
		     final String PASS = "12345";

		    // Set response content type
		    response.setContentType("text/html");
		    PrintWriter out1 = response.getWriter();
		    String title = "Database Result";
		    
		    String docType =
		       "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
		    
		    out1.println(docType +
		       "<html>\n" +
		       "<head><title>" + title + "</title></head>\n" +
		       "<body bgcolor = \"#f0f0f0\">\n" +
		       "<h1 align = \"center\">" + title + "</h1>\n");
		    try {
		       // Register JDBC driver
		       Class.forName("com.mysql.jdbc.Driver");

		       // Open a connection
		       Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		      // out1.println("conneted");  
		       // Execute SQL query
		       Statement stmt = conn.createStatement();
		       String citys = request.getParameter("city");
		       String sql;
		       sql = "SELECT id, first, last, age,city,joiningdate FROM employees ";
		       ResultSet rs = stmt.executeQuery(sql);

		       // Extract data from result set
		       while(rs.next()){
		          //Retrieve by column name
		          int id  = rs.getInt("id");
		          int age = rs.getInt("age");
		          String first = rs.getString("first");
		          String last = rs.getString("last");
		          String city = rs.getString("city");
		          Date joiningdate = rs.getDate("joiningdate");

		          //Display values
		          out1.println("ID: " + id + "<br>");
		          out1.println(", Age: " + age + "<br>");
		          out1.println(", First: " + first + "<br>");
		          out1.println(", Last: " + last + "<br>");
		          out1.println(", City: " + city + "<br>");
		          out1.println(", JoiningDate: " + joiningdate + "<br>");
		       }
		       out1.println("</body></html>");

		       // Clean-up environment
		       rs.close();
		       stmt.close();
		       conn.close();
		    } catch(SQLException se) {
		       //Handle errors for JDBC
		       se.printStackTrace();
		    } catch(Exception e) {
		       //Handle errors for Class.forName
		       e.printStackTrace();
		    }
	
				 
  }

%>
</center>

</body>
</html>