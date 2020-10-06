

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class employeeDetails
 */
@WebServlet("/myservlet")
public class employeeDetails extends HttpServlet {
	static int i;
    Connection con;
    PrintWriter out;
    ResultSet rs;
    public void init(){
        i=0;
        con=null;
        out=null;
        rs=null;
    }

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public employeeDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		i++;
        out=response.getWriter();
        out.println("<b>You are user number " + i + "to visit this site</b><br><br>");
        try{
            Class.forName("com.");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeeex","root","");
            PreparedStatement pstmt=null;
            String query=null;
            query="select fname,address,age,designation from employee where id=?";
            pstmt=con.prepareStatement(query);
            pstmt.setInt(1,Integer.parseInt(request.getParameter("id")));
            rs=pstmt.executeQuery();
            out.println("<b><center>Employee Details</center></b><br><br>");
            ResultSetMetaData rsmd=rs.getMetaData();
            int colcount=rsmd.getColumnCount();
            out.println("<table align=center border=1 cellpadding=2>");
            out.println("<tr>");
            for(int i=1; i<=colcount; i++){
                out.println("<th>" + rsmd.getColumnLabel(i) + "</th>");
            }
            out.println("<tr>");
            while(rs.next()){
                out.println("<tr>");
                out.println("<td>" + rs.getString("emp_fname") + "</td>");
                out.println("<td>" + rs.getString("address") + "</td>");
                out.println("<td>" + rs.getString("age") + "</td>");
                out.println("<td>" + rs.getString("desig") + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");
            out.println("</body>");
        }
        catch(Exception e){
            out.println(e.toString());
        }
    }
    public void destroy(){
        try{
            i=0;
            con.close();
            out.close();
            rs.close();
        }
        catch(SQLException se){
            out.println(se.toString());
        }
    }
}
