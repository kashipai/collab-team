package trainingAssignment;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


@WebFilter(urlPatterns = "/DatabaseAccess") 
public class LoginAuthenticationFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
	       
	    PrintWriter out=response.getWriter();  
	    String username = request.getParameter("username");      
	    String password=request.getParameter("password");  
	    if(password.equals("admin") && username.equals("admin")){  
	    
	        chain.doFilter(request, response);//sends request to next resource  
	    }  
	    else{  
		    out.print("username or password error!");  
		    RequestDispatcher rd=request.getRequestDispatcher("index.html");  
		    rd.include(request, response);  
	    }  
		
	}
	
  

}
