package examples;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class helloWorld
 */
@WebServlet(description = "a simple program", urlPatterns = { "/helloWorld" })
public class helloWorld extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public helloWorld() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		out.print("<h1>Employee details</h1>");
		out.print("<table border='1'><tr><th>ID</th><th>Name</th><th>phone</th><th>location</th></tr>");
		
		try {	
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/companytraining?characterEncoding=utf8","root","Sachu@1998"); 
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from emp_details");
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
				out.println(rs.getString(4));
				out.print("</td>");
				
			}
			
		}catch(Exception e) {
			System.out.println("DB Not Connected");
			System.out.println(e);
		}
		out.print("</table>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try { 
			 Class.forName("com.mysql.jdbc.Driver");
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/companytraining?characterEncoding=utf8","root","Sachu@1998");
			// Statement stmt=con.createStatement();
			  
	 
	        PreparedStatement st = con.prepareStatement("insert into emp_details values(?,?,?,?)"); 
	 
	        st.setInt(1,  Integer.valueOf(request.getParameter("empid")));

	       
	        st.setString(2, request.getParameter("name")); 
	        
	        st.setString(3,(request.getParameter("phone"))); 
	        
	        
	        st.setInt(4,  Integer.valueOf(request.getParameter("location")));

	        st.executeUpdate(); 

	        st.close(); 
	        
	        con.close(); 
	        
	        PrintWriter out=response.getWriter();
	        
	        System.out.println("Suceess");
	        
	        out.println("<html><body><b>Successfull"
	                    + "</b></body></html>"); 
	    } 
	    catch (Exception e) { 
	    	System.out.println("Problem!!");
	        e.printStackTrace(); 
	    } 
	}

}
