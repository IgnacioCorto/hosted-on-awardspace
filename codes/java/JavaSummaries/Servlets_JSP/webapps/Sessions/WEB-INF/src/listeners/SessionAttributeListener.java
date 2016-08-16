package listeners;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

//SESSION ATTRIBUTE CREATED OR DESTROYED??
public class SessionAttributeListener 
		implements HttpSessionAttributeListener {
			
	private ServletContext context ;
	
	public void attributeAdded  ( HttpSessionBindingEvent event ) {
		context = event.getSession().getServletContext();
		context.setAttribute("attributeStatus",
				"Session Attribute Added !!");
	}

	public void attributeRemoved  ( HttpSessionBindingEvent event ) {
		context = event.getSession().getServletContext();
		context.setAttribute("attributeStatus",
				"Session Attribute Removed !!");
	}

	public void attributeReplaced  ( HttpSessionBindingEvent event ) {
		context = event.getSession().getServletContext();
		context.setAttribute("attributeStatus",
				"Session Attribute Replaced !!");
	}


}
