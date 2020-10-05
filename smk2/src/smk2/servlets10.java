package smk2;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 * Servlet implementation class servlet1
 */
public class servlets10 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public servlets10() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		//String id=request.getParameter("id");
		response.setContentType("text/html");
		out.print("<h1>Employee details</h1>");
		out.print("<table border='1'><tr><th>ID</th><th>Name</th><th>Location</th><th>Salary</th></tr>");
		
		try {	
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/employee1?allowPublicKeyRetrieval=true&useSSL=false","root","root"); 
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from employee1");
			while(rs.next()) {
				
				out.print("<tr><td>");
				out.println(rs.getInt(1));
				System.out.println(rs.getString(1));
				out.print("</td>");
				out.print("<td>");
				out.println(rs.getString(2));
				out.print("</td>");
				out.print("<td>");
				out.println(rs.getString(3));
				out.print("</td>");
				out.print("<td>");
				out.println(rs.getInt(4));
				out.print("</td>");
				
			}
			
		}catch(Exception e) {
			System.out.println("DB Not Connected");
			System.out.println(e);
		}
		out.print("</table>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	 try { 
		 Class.forName("com.mysql.jdbc.Driver");
		 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee1?allowPublicKeyRetrieval=true&useSSL=false","root","root");
		// Statement stmt=con.createStatement();
		  
 
        PreparedStatement st = con.prepareStatement("insert into employee1 values(?,?,?,?)"); 
 
        st.setInt(1,  Integer.valueOf(request.getParameter("empid")));

       
        st.setString(2, request.getParameter("name")); 
        
        st.setString(3,(request.getParameter("location"))); 
        
        
        st.setInt(4,  Integer.valueOf(request.getParameter("salary")));

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

