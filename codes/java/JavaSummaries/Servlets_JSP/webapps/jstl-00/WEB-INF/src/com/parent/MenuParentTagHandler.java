package com.parent;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;
import java.util.*;

public class MenuParentTagHandler extends TagSupport {
	private ArrayList<String> elementos;

	public void agregarHijo(String nombre) {
		this.elementos.add(nombre);
	}

	public int doStartTag() throws JspException {
		elementos = new ArrayList<String>();
		return EVAL_BODY_INCLUDE;
	}

	public int doEndTag() throws JspException {
		try {
			pageContext.getOut().println("Elementos: "+this.elementos.toString());
		} catch(Exception ex) {
			throw new JspException("Exception: "+ex.toString());
		}
		return EVAL_BODY_INCLUDE;
	}
	

}