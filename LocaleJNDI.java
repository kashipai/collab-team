package i18n;

import java.io.*;
import java.sql.*;

import javax.naming.*;
import java.text.DateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Locale;
import java.util.ResourceBundle;


public class LocaleJNDI extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String title = "Connected using JNDI configuration";
    	PrintWriter out = response.getWriter();
     	Connection conn = null;
    	DataSource ds = null;
    	Context initContext;
    	Context envContext;
        try {
        	
		//using resource bundle to greet in french and display date of birth in french format
       	ResourceBundle bundle = ResourceBundle.getBundle("i18n.MessageBundle",Locale.FRANCE);
       	String greeting = bundle.getString("greeting");
        
        DateFormat formatter = DateFormat.getDateInstance(DateFormat.DEFAULT, Locale.FRANCE); 
        	
			
		//JNDI configuration
        initContext = new InitialContext();
        envContext = (Context) initContext.lookup("java:comp/env");
        ds = (DataSource) envContext.lookup("jdbc/UsersDB");
        conn = ds.getConnection();
   
       
        String sql;
        sql = "SELECT * FROM servletexercise.studetails;";
        ResultSet rs = stmt.executeQuery(sql);
            
            String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
            
            out.println(docType +
       	         "<html>\n" +
       	         "<head><title>" + title + "</title> <style>\r\n"
       	         		+ "table, th, td {\r\n"
       	         		+ "  border: 1px solid black;\r\n"
       	         		+ "  border-collapse: collapse;\r\n"
       	         		+ "  padding:5px;\r\n"
       	         		+ "}\r\n"
       	         		+ "</style></head>\n" +
       	         "<body>\n" +
       	         "<h1 align = \"center\">" + greeting + "</h1>\n");   
            

	         out.print("<center> <table>"
	         		+ "<tr><th>USN</th><th>Name</th><th>City</th><th>Birthday</th><</tr>");
            
            while (rs.next())
            {
            	String usn = rs.getString("usn");
				String city = rs.getString("city");
				String name = rs.getString("sname"); 
				Date dt = rs.getDate("dob");
				String date = formatter.format(dt);
				
				out.println("<tr><td>" + usn + "</td><td>" + name + "</td><td>" + city + "</td><td>" + date + "</td></tr>");  
            }
            out.print("</table>"+ "</body>");
            
            
            conn.close();
           statement.close();
            rs.close();
        } 
       catch (NamingException ne) 
        {
            System.out.println(ne.getMessage());
        } 
        catch (SQLException se) 
        {
            System.out.println(se.getMessage());
        }
       
    }
 
}