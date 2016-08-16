package com.simple;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class Simple3TagHandler extends SimpleTagSupport {

	// Funcion principal
	public void doTag() throws JspException, IOException {
		getJspContext().setAttribute("mensaje","Usar protector solar.");
		getJspBody().invoke(null);
	}
	
}