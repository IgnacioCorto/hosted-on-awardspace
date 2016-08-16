package objects;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

//AN OBJECT IN SESSION WAS CREATED OR DESTROYED??

public class DogListener 
		implements HttpSessionBindingListener, 
					HttpSessionActivationListener, 
					Serializable {
			
	private ServletContext context ;
	
	// CHANGE THE CONTEXT STATUS
	
	private void setContext(String message, HttpSessionEvent event ) {
		context = event.getSession().getServletContext();
		context.setAttribute("objectStatus", message);
	}
	
	// BOUND METHODS
	
	public void valueBound   ( HttpSessionBindingEvent event ) {
		setContext("Object Stored !!",event);
	}

	public void valueUnbound   ( HttpSessionBindingEvent event ) {
		setContext("Object Removed !!",event);
	}

	// MIGRATION METHODS

	public void sessionWillPassivate     ( HttpSessionEvent event ) {
		setContext("Session Will Passivate !!",event);
	}

	public void sessionDidActivate   ( HttpSessionEvent event ) {
		setContext("Session Did Activate !!",event);
	}

}
