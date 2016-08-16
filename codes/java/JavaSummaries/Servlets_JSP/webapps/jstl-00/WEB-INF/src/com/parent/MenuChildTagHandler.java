package com.parent;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;
import com.parent.MenuParentTagHandler;

public class MenuChildTagHandler extends TagSupport {
	private String name;

	public void setNombre(String name) { this.name=name; }
	public String getNombre() { return this.name; }

	public int doStartTag() throws JspException {
		return EVAL_BODY_INCLUDE;
	}

	public int doEndTag() throws JspException {
		MenuParentTagHandler parent = 
				(MenuParentTagHandler) 
				findAncestorWithClass(this,MenuParentTagHandler.class);
		parent.agregarHijo(this.name);
		return EVAL_PAGE;
	}
	
}