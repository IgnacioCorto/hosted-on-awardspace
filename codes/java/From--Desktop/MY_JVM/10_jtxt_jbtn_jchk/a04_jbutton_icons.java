// SOLO FUNCIONAN:
// normal, Rollover, Pressed, Disabled

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/*
<applet 
  codebase="temp"
  code="a04_jbutton_icons.class"
  alt="Probando Applet"
  name="a00_mouselistener"
  width="300"
  height="200"
  align="right"
  hspace="40"
  vspace="40"
>
<param name="parametro1" value="Interesante, pero no muy comun">
  Su computadora no soporta JAVA. Favor instalarlo.
</applet>
*/

public class a04_jbutton_icons extends JApplet
{
 public void init()
 {
	 Container contentPane = getContentPane();
	 
	 Icon normal = new ImageIcon("temp/normal.jpg");
	 Icon rollover = new ImageIcon("temp/rollover.jpg");
	 Icon pressed = new ImageIcon("temp/pulsado.jpg");
	 Icon disabled = new ImageIcon("temp/deshabilitado.jpg");
	 Icon selected = new ImageIcon("temp/seleccionado.jpg");
	 Icon rolloverSelected = new ImageIcon("temp/reseleccionado.jpg");
	 Icon disabledSelected = new ImageIcon("temp/deseleccionado.jpg");
	
	 JButton jbutton = new JButton();
	 jbutton.setRolloverEnabled(false);
	 
	 jbutton.setIcon(normal);
	 jbutton.setRolloverIcon(rollover);
	 jbutton.setRolloverSelectedIcon(rolloverSelected);
	 jbutton.setSelectedIcon(selected);
	 jbutton.setPressedIcon(pressed);
	 jbutton.setDisabledIcon(disabled);
	 jbutton.setDisabledSelectedIcon(disabledSelected);
	
	 contentPane.setLayout(new FlowLayout());
	 contentPane.add(jbutton);
	 contentPane.add(new JTextField("Hola"));

	 jbutton.setEnabled(true);
 }
}

