package trainingAssignment;

import java.io.IOException;

import java.sql.*;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class DatabaseAccess extends HttpServlet 
{      
	private static final long serialVersionUID = 1L;
	
        @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        	     Context ctx = null;
        	     Connection conn = null;  
        	     PreparedStatement st = null;
        	     ServletContext sc = this.getServletContext();
	             try {
		                ctx = new InitialContext();
		     			DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/MyDB");//jndi
		     			conn = ds.getConnection();
		     			st = conn.prepareStatement("insert into Employees values(?,?,?,?,?)");
	             	    st.setString(1,req.getParameter("empId"));
	             	    st.setString(2, req.getParameter("name"));
	             	    st.setString(3, req.getParameter("location"));
	             	    st.setString(4, req.getParameter("dateOfJoin"));
	             	    st.setString(5,req.getParameter("designation"));
	             	    st.executeUpdate();
	           	        ResultSet rs = st.executeQuery("SELECT * FROM Employees Order by location ");
	           	                  	        
	           	        req.setAttribute("resultSet", rs);
	                    RequestDispatcher rd =  sc.getRequestDispatcher("/EmployeeDataView.jsp");
	                    rd.forward(req, resp);
	             	} catch (SQLException | NamingException e) {
	         		    
	         			e.printStackTrace();
	         		}finally {
	         			  try {
							ctx.close();
						} catch (NamingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	                      try {
							st.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} 
	                      try {
							conn.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} 
					}	           
	        
    }
}
