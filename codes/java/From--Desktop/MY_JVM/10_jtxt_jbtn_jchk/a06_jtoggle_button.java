import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/*
<applet 
  codebase="temp"
  code="a06_jtoggle_button.class"
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

public class a06_jtoggle_button extends JApplet
{
 public void init()
 {
	 Container contentPane = getContentPane();
	 contentPane.setLayout(new FlowLayout());
	 
	 Icon icon = new ImageIcon("temp/pulsado.jpg");
	 ButtonGroup group = new ButtonGroup();
	 
	 JToggleButton[] buttons = new JToggleButton[] {
				 new JToggleButton(icon),				 new JToggleButton(icon),
				 new JToggleButton(icon),				 new JToggleButton(icon),
				 new JToggleButton(icon) };

  for (int i=0; i< buttons.length; i++)	 {
	 group.add(buttons[i]); 
	 contentPane.add(buttons[i]); }

 }
}

