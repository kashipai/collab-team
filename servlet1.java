

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
@WebServlet("/servlet1")
public class servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public servlet1() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		//String id=request.getParameter("id");
		response.setContentType("text/html");
		out.print("<h1>Display the employee record</h1>");
		out.print("<table border='1'><tr><th>name</th><th>location</th><th>ID</th><th>salary</th></tr>");
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","minion1112");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select *from employee");// where id="+id+ "");
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
			
		}catch(Exception e) {
			System.out.println(e);
		}
		out.print("</table>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	 try { 
		 Class.forName("com.mysql.jdbc.Driver");
		 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","minion1112");
		// Statement stmt=con.createStatement();
		  
 
        PreparedStatement st = con.prepareStatement("insert into employee values(?,?,?,?)"); 
 
        st.setString(1,(request.getParameter("name"))); 

       
        st.setString(2, request.getParameter("location")); 
        
        st.setInt(3,  Integer.valueOf(request.getParameter("ID")));
        st.setInt(4,  Integer.valueOf(request.getParameter("salary")));

        st.executeUpdate(); 

        st.close(); 
        con.close(); 
        PrintWriter out=response.getWriter();
        out.println("<html><body><b>Successfully Inserted"
                    + "</b></body></html>"); 
    } 
    catch (Exception e) { 
        e.printStackTrace(); 
    } 
} 
} 


