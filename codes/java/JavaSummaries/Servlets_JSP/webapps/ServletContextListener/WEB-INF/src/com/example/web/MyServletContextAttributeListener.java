package com.example.web;

import javax.servlet.*;

public class MyServletContextAttributeListener implements ServletContextAttributeListener {

	public void attributeAdded(ServletContextAttributeEvent event) { 
		String dato = "yes || " + event.getName();
		
		event.getServletContext().setAttribute( "added", dato );
	}
	public void attributeRemoved(ServletContextAttributeEvent event) { }
	public void attributeReplaced(ServletContextAttributeEvent event) { }

	
}