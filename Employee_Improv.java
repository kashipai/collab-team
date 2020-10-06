package servletPrograms;

import java.io.*;
import java.sql.*;
import javax.naming.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.util.Locale;
import java.util.ResourceBundle;

@WebServlet("/Employee")
public class Employee_Improv extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Employee_Improv() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String urlId = (null);
		urlId = request.getParameter("EmpId");
		response.setContentType("text/html");
		
		ResourceBundle bundle = ResourceBundle.getBundle("Message", Locale.US);  
/*	
		  //changing the default locale to French   
		 Locale.setDefault(new Locale("fr", "FR"));  
		  bundle = ResourceBundle.getBundle("Message");   */
		
		PrintWriter out = response.getWriter();
		String title=bundle.getString("title");
		String title1=bundle.getString("title1") +" "+ urlId;
		Connection con = null;
		Statement stmt = null;
		Context envContext = null;
		if (urlId == null) {
		String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
		out.println(docType + "<html>\n" + "<head><title>" + title + "</title></head>\n"
				+ "<body bgcolor = \"#f0f0f0\">\n" + "<h1 align = \"center\">" + title + "</h1>\n");
		}else {
			String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
			out.println(docType + "<html>\n" + "<head><title>" + title1 + "</title></head>\n"
					+ "<body bgcolor = \"#f0f0f0\">\n" + "<h1 align = \"center\">" + title1  + "</h1>\n");
		}
		try {
			envContext = new InitialContext();
			Context initContext = (Context) envContext.lookup("java:/comp/env");
			DataSource ds = (DataSource) initContext.lookup("jdbc/Database1");
			
			con = ds.getConnection();
			stmt = con.createStatement();
			
			String sql = "SELECT * FROM Database1.Employee where EmpId ='" + urlId + "'";
			if (urlId == null) {
				sql = "SELECT * FROM Database1.Employee";
			}

			ResultSet rs = stmt.executeQuery(sql);
			out.println("<table border=1");
			out.print("<tr><td>"+bundle.getString("EmpId")+"</td><td>"+bundle.getString("FirstName")+"</td><td>"+bundle.getString("LastName") +"</td><td>"+ bundle.getString("Age")+"</td>");

			while (rs.next()) {
				int id = rs.getInt("EmpId");
				int age = rs.getInt("age");
				String first = rs.getString("FirstName");
				String last = rs.getString("LastName");
				out.println("<tr><td>" + id + "</td><td>" + first + "</td><td>" + last + "</td><td>" + age + "</td></tr>");

			}
			out.println("</table>");
			out.println("</html></body>");

			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}
			try {
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
