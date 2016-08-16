package com.classic;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;

public class Classic4TagHandler extends TagSupport {

	JspWriter out;
	String [] peliculas = new String [] {"Titanic","Aviador","Blood Diamond"};
	int contadorPelicula;
	
	private void mostrarPelicula() {
		pageContext.setAttribute("pelicula",peliculas[contadorPelicula]);
		contadorPelicula++;
	}
	
	public int doStartTag() throws JspException {
		contadorPelicula=0;
		mostrarPelicula();
		return EVAL_BODY_INCLUDE;
	}
	
	public int doAfterBody() throws JspException {
		if(contadorPelicula<peliculas.length) {
			mostrarPelicula();
			return EVAL_BODY_AGAIN;
		} else {
			return SKIP_BODY;
		}		
	}
	
	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}
	
}