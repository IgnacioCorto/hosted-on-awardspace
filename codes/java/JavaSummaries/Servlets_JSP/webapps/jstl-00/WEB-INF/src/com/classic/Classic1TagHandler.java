package com.classic;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;

public class Classic1TagHandler extends TagSupport {

	// Funcion principal
	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try {
			out.println("Salida de un Tag Clasico");
		} catch (IOException ex) {
			throw new JspException( "IOException- " + ex.toString() );
		}
		return SKIP_BODY;
	}
	
}