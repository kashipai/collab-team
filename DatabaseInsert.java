import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

// Extend HttpServlet class
public class DatabaseInsert extends HttpServlet {
	static int id;
	static String name;
	static String city;
	static String designation;
	static int age;

	
   // Method to handle GET method request.
   public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      
	   response.setContentType("text/html");
	      PrintWriter out = response.getWriter();
	      String title = "Employee Details";
	      
	      String docType =
	         "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
	      
	      out.println(docType +
	         "<html>\n" +
	         "<head><title>" + title + "</title> <style>\r\n"
	         		+ "table, th, td {\r\n"
	         		+ "  border: 1px solid black;\r\n"
	         		+ "  border-collapse: collapse;\r\n"
	         		+ "  padding:5px;\r\n"
	         		+ "}\r\n"
	         		+ "</style></head>\n" +
	         "<body>\n" +
	         "<h1 align = \"center\">" + title + "</h1>\n");
	      
	      try {
	         // Register JDBC driver
	         Class.forName("com.mysql.jdbc.Driver");

	         // Open a connection
	         Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servletexercise","root", "MySql@123");
	         
	         Statement stmt = conn.createStatement();
	         String sql;
	         sql = "SELECT * FROM Employees";
	         ResultSet rs = stmt.executeQuery(sql);
	       
	         out.print("<center> <table>"
	         		+ "<tr><th>ID</th><th>Name</th><th>City</th><th>Age</th><th>Designation</th></tr>");
	         
	         while(rs.next()){
	            
	            int id  = rs.getInt("id");
	            int age = rs.getInt("age");
	            String desg = rs.getString("designation");
	            String name = rs.getString("name");
	            String city = rs.getString("city");
	            
	            out.print("<tr><td>");
				out.println(rs.getInt("id"));
				out.print("</td>");
				out.print("<td>");
				out.println(rs.getString("name"));
				out.print("</td>");
				out.print("<td>");
				out.println(rs.getString("city"));
				out.print("</td>");
				out.print("<td>");
				out.println(age);
				out.print("</td>");
				out.print("<td>");
				out.println(designation);
				out.print("</td>");
				out.print("</tr>");
	         }
	         out.print("</table></center>");
	        
	         rs.close();
	         stmt.close();
	         conn.close();
	      } catch(SQLException se) {
	         
	         se.printStackTrace();
	      } catch(Exception e) {
	         
	         e.printStackTrace();
	      } 
      
   }

   
   public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
	   
	      PrintWriter out = response.getWriter();
	   try
	   {
		   name = request.getParameter("name");
           id = Integer.parseInt(request.getParameter("id"));
           age = Integer.parseInt( request.getParameter("age"));
           city = request.getParameter("city");
           designation = request.getParameter("designation");
		   
	   Class.forName("com.mysql.jdbc.Driver");
	   Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servletexercise","root", "MySql@123");
	   Statement st=conn.createStatement();

	   int i=st.executeUpdate("insert into employees(id,name,city,designation,age)values("+id+",'"+name+"','"+city+"','"+designation+"',"+age+")");
	  
	   out.println("<center>");
	   out.println("<h2>Data is successfully inserted!</h2>");
	   out.println("</center>");
	   }
	   
	   
	   catch(Exception e)
	   {
	   out.println(e);

	   e.printStackTrace();
	   }

      doGet(request, response);
   }
}