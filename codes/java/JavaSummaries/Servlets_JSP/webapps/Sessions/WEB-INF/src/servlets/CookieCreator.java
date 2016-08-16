package servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class CookieCreator extends HttpServlet {
	public void doPost (HttpServletRequest request,
					HttpServletResponse response)
					throws IOException,ServletException {

		Cookie cookie 
			= new Cookie(
				"username",
				request.getParameter("username")
				);
		cookie.setMaxAge(30*60);
		response.addCookie(cookie);
			
		RequestDispatcher view 
			= request.getRequestDispatcher("username.jsp");
		view.forward(request,response);
	}
}