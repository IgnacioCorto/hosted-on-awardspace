package com.example.web;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class ListenerTester extends HttpServlet {
	public void doGet (HttpServletRequest request,
					HttpServletResponse response)
					throws IOException
					, ServletException    //BeerSelect v3 
					{
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("test context attribute set by listener <br><br>");
		
		Dog dog = (Dog) getServletContext().getAttribute("dog");
		out.println( "Dog's breed is: " + dog.getBreed() + "<br>");

		getServletContext().setAttribute("new one", new String("New One Added") );
		
		String dato = (String) getServletContext().getAttribute("added");
		out.println( "Attribute added?? <b>" + dato + "</b><br>");
		
	}
}