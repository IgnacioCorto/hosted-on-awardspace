package com.parent;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class SimpleInnerTagHandler extends SimpleTagSupport {

	// Funcion principal
	public void doTag() throws JspException, IOException {
		ClassicOuterTagHandler parent = (ClassicOuterTagHandler) getParent();
		getJspContext().getOut().write("Atributo Padre: "+parent.getName());
	}
	
}