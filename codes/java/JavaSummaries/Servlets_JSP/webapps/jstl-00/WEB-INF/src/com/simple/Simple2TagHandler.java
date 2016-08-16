package com.simple;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class Simple2TagHandler extends SimpleTagSupport {

	// Funcion principal
	public void doTag() throws JspException, IOException {
		getJspBody().invoke(null);
	}
	
}