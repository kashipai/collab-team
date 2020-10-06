package servletPrograms;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet("/EmployeeDisplay")
public class EmployeeDisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EmployeeDisplay() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		final String DB_URL = "jdbc:mysql://localhost:3306/Database1";

		// Database credentials
		final String USER = "root";
		final String PASS = "MySQLpassword";

		String urlId = (null);
		urlId = request.getParameter("EmpId");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String title;
		title = "Employee Record of EmpId " + urlId;
		if (urlId == null) {
			title = "Employee Record ";
		}
		Connection conn = null;
		Statement stmt = null;

		String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
		out.println(docType + "<html>\n" + "<head><title>" + title + "</title></head>\n"
				+ "<body bgcolor = \"#f0f0f0\">\n" + "<h1 align = \"center\">" + title + "</h1>\n");
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT * FROM Database1.Employee where EmpId ='" + urlId + "'";
			if (urlId == null) {
				sql = "SELECT * FROM Database1.Employee";
			}

			ResultSet rs = stmt.executeQuery(sql);
			out.println("<table border=1");
			out.println("<tr><th>EmpId</th><th>First Name</th><th>Last Name</th><th>Age</th><tr>");
			while (rs.next()) {
				int id = rs.getInt("EmpId");
				int age = rs.getInt("age");
				String first = rs.getString("FirstName");
				String last = rs.getString("LastName");
				out.println(
						"<tr><td>" + id + "</td><td>" + first + "</td><td>" + last + "</td><td>" + age + "</td></tr>");

			}
			out.println("</table>");
			out.println("</html></body>");

			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}
			try {
				if (conn != null)
					conn.close();
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
