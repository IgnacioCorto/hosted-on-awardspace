import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
<applet 
  codebase="temp"
  code="a09_jradiobutton_image.class"
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

public class a09_jradiobutton_image extends JApplet implements ItemListener
{
 JCheckBox check1;
 JTextField text;
 
 public void init()
 {
  Container contentPane = getContentPane();
	contentPane.setLayout(new FlowLayout());
	
	check1 = new JCheckBox("Opcion 1", new ImageIcon("temp/normal.jpg"));
  check1.setSelectedIcon(new ImageIcon("temp/pulsado.jpg"));

	contentPane.add(check1);
  check1.addItemListener(this);
	
	text = new JTextField(20);
	contentPane.add(text);		
 }
 
 	public void itemStateChanged(ItemEvent e)
	{
	 if (e.getItemSelectable() == check1)
	  text.setText("Selecciono la casilla  #1");
	}

}

