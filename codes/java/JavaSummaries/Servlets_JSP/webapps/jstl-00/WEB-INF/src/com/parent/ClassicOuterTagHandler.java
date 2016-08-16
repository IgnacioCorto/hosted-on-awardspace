package com.parent;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;

public class ClassicOuterTagHandler extends TagSupport {
	private String name;

	public void setName(String name) { this.name=name; }
	public String getName() { return this.name; }

	public int doStartTag() throws JspException {
		return EVAL_BODY_INCLUDE;
	}
	
}