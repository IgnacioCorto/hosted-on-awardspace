package servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class CookieChecker extends HttpServlet {
	public void doGet (HttpServletRequest request,
					HttpServletResponse response)
					throws IOException,ServletException {

		Cookie [] cookies  
			= request.getCookies();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		for(int i=0;i<cookies.length;i++) {
			if(cookies[i].getName().equals("username")) {
				out.println("<h1>Getting Cookie...</h1>"
				+ "<p>Hello,"+cookies[i].getValue()+"</p>"
				+ "<a href='./'>Go to Index</a>"
				);
			}
		}
		
	}
}