package com.example.web;

import com.example.model.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;


public class BeerSelect extends HttpServlet {
	public void doPost (HttpServletRequest request,
					HttpServletResponse response)
					throws IOException
					, ServletException    //BeerSelect v3 
					{
		
		//response.setContentType("text/html");     //BeerSelect v1-2
		//PrintWriter out = response.getWriter();   //BeerSelect v1-2
		//out.println("Beer Selection Advice<br>"); //BeerSelect v1-2

		String c = request.getParameter("color");

		// out.println("<br>Got beer color " + c);  //BeerSelect v1
		
		BeerExpert be = new BeerExpert();
		List<String> result = (ArrayList<String>) be.getBrands(c);
		
		//Iterator it = result.iterator();        //BeerSelect v2
		//while(it.hasNext()) {                   //BeerSelect v2
		//	out.print("<br>try: " + it.next());   //BeerSelect v2
		//}                                       //BeerSelect v2
		
		request.setAttribute("styles",result);
		RequestDispatcher view = 
			request.getRequestDispatcher("result.jsp");
		view.forward(request, response);
		
	}
}