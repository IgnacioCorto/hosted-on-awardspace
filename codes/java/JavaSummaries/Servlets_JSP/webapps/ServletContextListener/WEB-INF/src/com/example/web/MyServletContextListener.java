package com.example.web;

import javax.servlet.*;

public class MyServletContextListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent event) {
		String dogBreed = event.getServletContext().getInitParameter("breed");
		Dog d = new Dog(dogBreed);
		event.getServletContext().setAttribute("dog", d);
	}

	public void contextDestroyed(ServletContextEvent event) {
		//nothing to do here
	}
	
}