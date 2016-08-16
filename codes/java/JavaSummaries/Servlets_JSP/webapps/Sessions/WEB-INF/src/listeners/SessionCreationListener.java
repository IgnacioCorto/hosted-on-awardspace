package listeners;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

//SESSION CREATED OR DESTROYED??
public class SessionCreationListener 
		implements HttpSessionListener {
			
	private ServletContext context ;
	
	public void sessionCreated ( HttpSessionEvent event ) {
		context = event.getSession().getServletContext();
		context.setAttribute("sessionStatus",
				"Session Created !!");
	}

    public void sessionDestroyed ( HttpSessionEvent event ) {
		context = event.getSession().getServletContext();
		context.setAttribute("sessionStatus",
				"Session Destroyed !!");
	}

}
