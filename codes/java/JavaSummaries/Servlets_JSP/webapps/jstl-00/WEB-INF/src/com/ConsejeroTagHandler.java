package com;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class ConsejeroTagHandler extends SimpleTagSupport {

	private String usuario;
	
	// Funcion principal
	public void doTag() throws JspException, IOException {
		getJspContext().getOut().write("Hola "+usuario+". ");
		getJspContext().getOut().write("Consejo: "+obtenerConsejo()+". ");
	}

	//Funcion para asignar Usuario
	public void setUsuario(String usuario) {
		this.usuario=usuario;
	}
	
	//__Utilidades__
	String obtenerConsejo() {
		String [] consejos = { "Ese color no funciona contigo",
				"Reportate como enfermo",
				"Deberias cambiar el corte de pelo"};
		int aleatorio = (int) (Math.random() * consejos.length);
		return consejos[aleatorio];
	}
	
	
}