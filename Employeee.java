package Began;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Employeee")
public class Employeee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Employeee() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		final String DB_URL = "jdbc:mysql://localhost:3306/database2";
		final String USER = "root";
		final String PASS = "naruto#420";
		String urlId = (null);
		urlId = request.getParameter("EmpId");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String title = "Employee Record of EmpId " + urlId;
		if (urlId == null) {
			title = "Employee Record ";
		}
		Connection conn = null;
		Statement stmt = null;
		String docType = "<!doctype html>\n";

		out.println(docType + "<html>\n" + "<head><title>" + title + "</title></head>\n"
				+ "<body bgcolor = \"#f0f0f0\">\n" + "<h1 align = \"center\">" + title + "</h1>\n");
		try {

			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT * FROM database2.emptable where EmpId ='" + urlId + "'";
			if (urlId == null) {
				sql = "SELECT * FROM database2.emptable";
			}
			ResultSet rs = stmt.executeQuery(sql);
			out.println("<table border=1 width=50% height=50%>");
			out.println(
					"<tr><th>Employee Id</th><th>First Name</th><th>Last Name</th><th>Salaray</th><th>Age</th><tr>");

			while (rs.next()) {

				int id = rs.getInt("EmpId");
				String first = rs.getString("FirstName");
				String last = rs.getString("LastName");
				int salary = rs.getInt("Salary");
				int age = rs.getInt("Age");

				out.println("<tr><td>" + id + "</td><td>" + first + "</td><td>" + last + "</td><td>" + salary
						+ "</td><td>" + age + "</td></tr>");
			}
			out.println("</table>");
			out.println("</html></body>");
			rs.close();
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
		doGet(request,response);
}
}