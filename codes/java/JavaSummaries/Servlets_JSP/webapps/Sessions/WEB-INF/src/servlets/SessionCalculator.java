package servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class SessionCalculator extends HttpServlet {
	
	public void doGet (HttpServletRequest request,
					HttpServletResponse response)
					throws IOException,ServletException {
		doPost(request,response);
	}
	public void doPost (HttpServletRequest request,
					HttpServletResponse response)
					throws IOException,ServletException {

		HttpSession session = request.getSession();
		
		int first=0,last=0;
		double total=0.0;
		String buffer="", operator="",
			   template="first.jsp";
		
		buffer=request.getParameter("first");
		if(buffer!=null) {
			session.setAttribute("first",buffer);
			template="operator.jsp";
		}
		
		buffer=request.getParameter("operator");
		if(buffer!=null) {
			session.setAttribute("operator",buffer);
			template="last.jsp";
		}

		buffer=request.getParameter("last");
		if(buffer!=null) {
			session.setAttribute("last",buffer);
			template="total.jsp";
			
			buffer = (String) session.getAttribute("first");
			first = Integer.parseInt(buffer);

			buffer = (String) session.getAttribute("last");
			last = Integer.parseInt(buffer);
				
			operator = (String) session.getAttribute("operator");
			
			if(operator.equals("+")) total = first + last ;
			if(operator.equals("-")) total = first - last ;
			if(operator.equals("*")) total = first * last ;
			if(operator.equals("/")) total = first / last ;
			
			request.setAttribute("formula", 
				Integer.toString(first)
				+operator
				+Integer.toString(last));
			request.setAttribute("total", 
				Double.toString(total));
			
		}
		
		RequestDispatcher view 
			= request.getRequestDispatcher(template);
		view.forward(request,response);
		
		
	}
}