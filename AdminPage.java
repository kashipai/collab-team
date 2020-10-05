package trainingAssignment;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DatabaseAccess")
public class AdminPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

		public void doGet(HttpServletRequest request, HttpServletResponse response)  
		        throws ServletException, IOException {  
		  
		        response.setContentType("text/html");  
		        PrintWriter out = response.getWriter();  
		         
		        out.println("welcome ADMIN");  
		        out.println("<form action='register' method = 'post' >");

                out.println("<body align =\"center\">Enter empID :<input type=\"text\" name =\"empId\"><br><br>");
                out.println("Enter name :<input type=\"text\" name =\"name\"><br><br>");
                out.println("Enter dateOfJoin :<input type=\"date\" name =\"dateOfJoin\"><br><br>");
		        out.println(" Enter designation :<input type=\"text\" name =\"designation\"><br><br>\r\n" + 
		        		"	   <input type=\"submit\"></form>\r\n" + 
		        		"</body>");
                out.close();  
		    }  
}  


