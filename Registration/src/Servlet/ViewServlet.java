package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/view")
public class ViewServlet extends HttpServlet {
	//private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ViewServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
       RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/index.html");
       dispatcher.forward(request,response);
       
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method 
		PrintWriter out = response.getWriter();

		if(request.getParameter("button1") != null) {
		
			//out.println("view button");
			
			// JDBC driver name and database URL
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
		         String sql;
		         sql = "SELECT id, first, last, age FROM employees";
		         ResultSet rs = stmt.executeQuery(sql);

		         // Extract data from result set
		         while(rs.next()){
		            //Retrieve by column name
		            int id  = rs.getInt("id");
		            int age = rs.getInt("age");
		            String first = rs.getString("first");
		            String last = rs.getString("last");

		            //Display values
		            out1.println("ID: " + id + "<br>");
		            out1.println(", Age: " + age + "<br>");
		            out1.println(", First: " + first + "<br>");
		            out1.println(", Last: " + last + "<br>");
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
			
		
		if(request.getParameter("button2") != null) {
			
		    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/newentry.html");
		       dispatcher.forward(request,response);
			
		}
		
		
		
	}
}


