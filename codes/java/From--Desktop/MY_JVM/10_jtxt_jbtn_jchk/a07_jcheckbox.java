import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/*
<applet 
  codebase="temp"
  code="a07_jcheckbox.class"
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

public class a07_jcheckbox extends JApplet implements ItemListener
{
 JCheckBox check1, check2, check3, check4;
 JTextField text;
 
 public void init()
 {
	 Container contentPane = getContentPane();
	 contentPane.setLayout(new FlowLayout());
	 
	 check1 = new JCheckBox("Casilla #1");
	 check2 = new JCheckBox("Casilla #2");
	 check3 = new JCheckBox("Casilla #3");
	 check4 = new JCheckBox("Casilla #4");

   check1.addItemListener(this);
   check2.addItemListener(this);
   check3.addItemListener(this);
   check4.addItemListener(this);
	 
	 contentPane.add(check1);
	 contentPane.add(check2);
	 contentPane.add(check3);
	 contentPane.add(check4);
	 
	 text = new JTextField(20);
	 contentPane.add(text);
	}
	
	public void itemStateChanged(ItemEvent e)
	{
	 if (e.getItemSelectable() == check1)
	  text.setText("Selecciono la casilla  #1");
	 if (e.getItemSelectable() == check2)
	  text.setText("Selecciono la casilla  #2");
	 if (e.getItemSelectable() == check3)
	  text.setText("Selecciono la casilla  #3");
	 if (e.getItemSelectable() == check4)
	  text.setText("Selecciono la casilla  #4");
	}
	 	 
}

