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
   
   Context ctx = null;
   Connection con = null;
   PreparedStatement st=null;
	
	
	
try { 
	ctx = new InitialContext();
	DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/employee");
		
	con = ds.getConnection();

   st = con.prepareStatement("insert into employee values(?,?,?,?)"); 

   st.setString(1,(request.getParameter("name"))); 

  
   st.setString(2, request.getParameter("location")); 
   
   st.setInt(3,  Integer.valueOf(request.getParameter("ID")));
   st.setInt(4,  Integer.valueOf(request.getParameter("salary")));
   
   st.executeUpdate(); 

   
   out.println("<html><body><b>Successfully Inserted"
               + "</b></body></html>"); 
} 
catch (Exception e) { 
   e.printStackTrace(); 
} finally{
	try {
		
		st.close();
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