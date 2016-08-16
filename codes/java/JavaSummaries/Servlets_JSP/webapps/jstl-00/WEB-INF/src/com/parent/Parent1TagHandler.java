package com.parent;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;

public class Parent1TagHandler extends TagSupport {
	private int nivelAnidado=0;

	public int doStartTag() throws JspException {
		nivelAnidado=0;
		Tag parent = getParent();
		
		while(parent!=null) {
			parent = parent.getParent();
			nivelAnidado++;
		}
		
		try {
			JspWriter out = pageContext.getOut();
			out.println("Nivel#"+nivelAnidado);
		} catch (IOException ex) {
			throw new JspException( "IOException- " + ex.toString() );
		}
		return EVAL_BODY_INCLUDE;
	}
	
}