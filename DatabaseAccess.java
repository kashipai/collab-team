package trainingAssignment;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/register")
public class DatabaseAccess extends HttpServlet 
{      
	private static final long serialVersionUID = 1L;
	
        @Override
    public void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
    	
	        	String dbDriver = "com.mysql.jdbc.Driver"; 
	            String dbURL = "jdbc:mysql:// 127.0.0.1:3306/Test";
	            //String dbName = "Test"; 
	            String dbUsername = "sneha"; 
	            String dbPassword = "sneha@123";
	            response.setContentType("text/html");
	            PrintWriter out = response.getWriter();
	            String title = "Database Result";
	            String docType =
	                    "<!doctype html>";
	                 
                 out.println(docType +
                    "<html>\n" +
                    "<head><title>" + title + "</title></head>\n" +
               
                    "<h1 align = \"center\">" + title + "</h1>\n");
                
	             try {
	             		Class.forName(dbDriver); 
	             		Connection conn = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
	             	    PreparedStatement st = conn.prepareStatement("insert into Employees values(?,?,?,?)");
	             	    st.setString(1,req.getParameter("empId"));
	             	    st.setString(2, req.getParameter("name"));
	             	    st.setString(3, req.getParameter("dateOfJoin"));
	             	    st.setString(4,req.getParameter("designation"));
	             	    st.executeUpdate();
	             	    
	                    // PrintWriter out = response.getWriter(); 
	                     out.println("<body ><h2 align = \"center\">Successfully Inserted the Record!!!</h2>"
	                                 + "<table align = \"center\" border='1'>");
	                     out.println("<h3 align = \"center\">Database after insertion of the record :</h3>");
	                     ResultSet rs = st.executeQuery("SELECT * FROM Employees");
	                     while(rs.next()){
	                         //Retrieve by column name
	                         String empId  = rs.getString(1);
	                         String name = rs.getString(2);
	                         Date dateOfJoin = rs.getDate(3);
	                         String designation = rs.getString(4);
	
	                         //Display values
	                         
	                         out.println("<tr><td> empId : " + empId + "</td>");
	                         out.println("<td> name : " + name + "</td>");
	                         out.println("<td> Date Of Join : " + dateOfJoin + "</td>");
	                         out.println("<td> designation : " + designation + "</td></tr>");
	                      }
	                      out.println("</table></body></html>");
	                      st.close(); 
	                      conn.close(); 
	             	} catch (ClassNotFoundException | SQLException e) {
	         		    
	         			e.printStackTrace();
	         		}
	        
    }
}
