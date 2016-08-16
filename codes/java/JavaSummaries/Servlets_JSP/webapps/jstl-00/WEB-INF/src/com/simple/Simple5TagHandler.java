package com.simple;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.*;

public class Simple5TagHandler extends SimpleTagSupport {
	
	private List listaDePeliculas;
		
	public void setListaDePeliculas(List listaDePeliculas) {
		this.listaDePeliculas=listaDePeliculas;
	}

	// Funcion principal
	public void doTag() throws JspException, IOException {
		Iterator i = listaDePeliculas.iterator();
		while( i.hasNext() ) {
			Pelicula pelicula = (Pelicula) i.next();
			getJspContext().setAttribute("pelicula",pelicula);
			getJspBody().invoke(null);
		}
	}
	
}