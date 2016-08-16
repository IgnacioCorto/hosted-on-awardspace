package com.simple;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class Simple6TagHandler extends SimpleTagSupport {
	
	// Funcion principal
	public void doTag() throws JspException, IOException {
		getJspContext().getOut().print("Viene un SkipPageException...");
		throw new SkipPageException();
	}
	
}