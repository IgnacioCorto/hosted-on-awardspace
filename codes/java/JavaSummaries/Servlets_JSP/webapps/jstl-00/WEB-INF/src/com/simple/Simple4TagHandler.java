package com.simple;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class Simple4TagHandler extends SimpleTagSupport {
	
	String [] peliculas = {"Spiderman","Hulk","Ironman"};

	// Funcion principal
	public void doTag() throws JspException, IOException {
		for(int i=0 ; i<peliculas.length ; i++ ) {
			getJspContext().setAttribute("pelicula",peliculas[i]);
			getJspBody().invoke(null);
		}
	}
	
}