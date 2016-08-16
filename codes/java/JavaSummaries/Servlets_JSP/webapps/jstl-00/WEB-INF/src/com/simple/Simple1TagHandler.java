package com.simple;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class Simple1TagHandler extends SimpleTagSupport {

	// Funcion principal
	public void doTag() throws JspException, IOException {
		getJspContext().getOut().write("El peor uso para un SimpleTag");
	}
	
}