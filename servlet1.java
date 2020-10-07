

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.DriverManager;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

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
		Context ctx = null;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		out.print("<h1>Display the employee record</h1>");
		out.print("<table border='1'><tr><th>name</th><th>location</th><th>ID</th><th>salary</th></tr>");
		
		try {
			
			ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/employee");
			
			con = ds.getConnection();
			stmt = con.createStatement();
			rs=stmt.executeQuery("select *from employee");// where id="+id+ "");
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
			 out.print("</table></body><br/>");
	         out.print("<h3>Database Details</h3>");
	         out.print("Database Product: "+con.getMetaData().getDatabaseProductName()+"<br/>");
	         out.print("Database Driver: "+con.getMetaData().getDriverName());
	         out.print("</html>");
			
			
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
	}


	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

        st.close(); 
        con.close(); 
        PrintWriter out=response.getWriter();
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
	}
}



