package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method 
		PrintWriter out = response.getWriter();
		 final String DB_URL="jdbc:mysql://localhost/test?characterEncoding=latin1";

	      //  Database credentials
	       final String USER = "root";
	       final String PASS = "12345";
	       
		if(request.getParameter("sbutton") != null) {
			//out.println("hello");
			String userid = request.getParameter("userId");
			//out.println(userid); 
			String userAge = request.getParameter("userAge");
			//out.println(userAge); 
			String userFname = request.getParameter("userFname");
		//out.println(userFname); 
		String userLname = request.getParameter("userLname");
		//out.println(userLname); 
		try {
		 Class.forName("com.mysql.jdbc.Driver");

         // Open a connection
         Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
       
         // Execute SQL query
         Statement stmt = conn.createStatement();
		
		Statement st = conn.createStatement();
		String sql = "insert into employees (id,age,first,last) values('" + userid + "','" + userAge + "','" + userFname + "','" + userLname + "')";
		st.executeUpdate(sql);
		 stmt.close();
         conn.close();
		}catch(SQLException se) {
	         //Handle errors for JDBC
	         se.printStackTrace();
	      } catch(Exception e) {
	         //Handle errors for Class.forName
	         e.printStackTrace();
	      }finally {
	    	  out.println("Added Successfully");
	      }
	}

}
}
