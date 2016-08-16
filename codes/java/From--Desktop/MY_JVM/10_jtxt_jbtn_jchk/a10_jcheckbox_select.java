import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
<applet 
  codebase="temp"
  code="a10_jcheckbox_select.class"
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

public class a10_jcheckbox_select extends JApplet implements ItemListener
{
 JCheckBox checks[];
 JTextField text;

 public void init()
 {
  Container contentPane = getContentPane();
	contentPane.setLayout(new FlowLayout());
	
	checks = new JCheckBox[4];
	
	for (int i=0; i<checks.length ; i++) {
	 //System.out.println("Prueba");
   checks[i]=new JCheckBox("Casilla #"+i);
	 checks[i].addItemListener(this);
	 contentPane.add(checks[i]); }
	 
 	text = new JTextField(20);
	contentPane.add(text);			 
	 
 }
 
 	public void itemStateChanged(ItemEvent e)
	{
	 String outString = new String("Seleccionadas:");
	 
		for (int i=0; i<checks.length;i++) {
		 if(checks[i].isSelected()) {
			outString += " #"+i; }}
			
	 text.setText(outString);
		
	}

}

