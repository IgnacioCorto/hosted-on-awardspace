package com.classic;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;

public class Classic2TagHandler extends TagSupport {

	JspWriter out;
	
	public int doStartTag() throws JspException {
		out = pageContext.getOut();
		try {
			out.println("en doStartTag() ...");
		} catch (IOException ex) {
			throw new JspException( "IOException- " + ex.toString() );
		}
		return SKIP_BODY;
	}
	
	public int doEndTag() throws JspException {
		try {
			out.println("en doEndTag() ...");
		} catch (IOException ex) {
			throw new JspException( "IOException- " + ex.toString() );
		}
		return EVAL_PAGE;
	}
	
}