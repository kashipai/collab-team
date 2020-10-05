// Loading required libraries
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
 
public class FilterByCity extends HttpServlet{

   public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
   
	   String urlCity = request.getParameter("city");

     Connection conn;
      Statement stmt;
      ResultSet rs;
	   
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      String title = "Employees from "+urlCity;
      
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
         "<h1 align = \"center\" color = crimson>" + title + "</h1>\n");
      try {
         
         Class.forName("com.mysql.jdbc.Driver");

         conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servletexercise","root", "MySql@123");
         
         stmt = conn.createStatement();
         String sql;
         sql = "SELECT * FROM Employees where city ='"+urlCity+"'";
          rs = stmt.executeQuery(sql);

         out.print("<center><table>"
	         		+ "<tr><th>ID</th><th>Name</th><th>City</th><th>Age</th><th>Designation</th></tr>");
	         
	         while(rs.next()){
	        	 
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
					out.println(rs.getInt("age"));
					out.print("</td>");
					out.print("<td>");
					out.println(rs.getString("designation"));
					out.print("</td>");
					out.print("</tr>");
	         }
	         out.print("</table></center>");

	         rs.close();
	          stmt.close();
	          conn.close();
	      
     
      } catch(SQLException se) {
     
         se.printStackTrace();
      }
      catch(ClassNotFoundException e) {
     
         e.printStackTrace();
      }
 
     
   }
} 