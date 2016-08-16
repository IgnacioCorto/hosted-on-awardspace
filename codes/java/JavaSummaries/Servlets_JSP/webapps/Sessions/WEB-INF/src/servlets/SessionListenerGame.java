package servlets;

import objects.DogListener;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class SessionListenerGame extends HttpServlet {
	
	public void doGet (HttpServletRequest request,
					HttpServletResponse response)
					throws IOException,ServletException {
		doPost(request,response);
	}
					
	public void doPost (HttpServletRequest request,
					HttpServletResponse response)
					throws IOException,ServletException {
		
		HttpSession session = request.getSession();
		//session.setAttribute("fromServlet", new Boolean(false));
		DogListener dog = new DogListener();
		
						
		if(request.getParameter("createSession")!=null) {
			// Maybe Usefull some day ...
		} else if(request.getParameter("destroySession")!=null) {
			session.invalidate();
			
		} else if(request.getParameter("setAttribute")!=null) {
			session.setAttribute("dummyAttribute","dummy");
		} else if(request.getParameter("removeAttribute")!=null) {
			session.removeAttribute("dummyAttribute");
		
		} else if(request.getParameter("addObject")!=null) {
			session.setAttribute("dogObject",dog);
		} else if(request.getParameter("removeObject")!=null) {
			session.removeAttribute("dogObject");
		} 
		
		RequestDispatcher view 
			= request.getRequestDispatcher("SessionListenerGame.jsp");
		view.forward(request,response);
		
		
	}
}