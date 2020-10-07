package began;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/Emply")
public class Emply extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Emply() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = null;
		Statement stmt = null;
		Context envContext = null;
		ResourceBundle bundle = ResourceBundle.getBundle("Message", Locale.US);

		Locale.setDefault(new Locale("gr", "GR"));
		bundle = ResourceBundle.getBundle("Message");

		PrintWriter out = response.getWriter();
		String title = bundle.getString("title");

		String docType = "<!doctype html>\n";
		out.println(docType + "<html>\n" + "<head><title>" + title + "</title></head>\n"
				+ "<body bgcolor = \"#f0f0f0\">\n" + "<h1 align = \"center\">" + title + "</h1>\n");
		try {
			envContext = new InitialContext();
			Context initContext = (Context) envContext.lookup("java:/comp/env");
			DataSource ds = (DataSource) initContext.lookup("jdbc/database2");

			Connection con = ds.getConnection();

			Statement stmt1 = con.createStatement();
			String query = "SELECT * FROM database2.emptable";
			ResultSet rs = stmt1.executeQuery(query);

			response.setContentType("text/html");
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
		doGet(request, response);
	}

}
