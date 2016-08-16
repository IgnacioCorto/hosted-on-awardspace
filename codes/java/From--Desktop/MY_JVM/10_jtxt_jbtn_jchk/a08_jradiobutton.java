import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
<applet 
  codebase="temp"
  code="a08_jradiobutton.class"
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

public class a08_jradiobutton extends JApplet implements ItemListener
{
 JRadioButton radio1, radio2, radio3, radio4;
 ButtonGroup group;
 JTextField text;
 
 public void init()
 {
  Container contentPane = getContentPane();
	contentPane.setLayout(new FlowLayout());
	
  group = new ButtonGroup();
	
	radio1 = new JRadioButton("Opcion 1");
	radio2 = new JRadioButton("Opcion 2");
	radio3 = new JRadioButton("Opcion 3");
	radio4 = new JRadioButton("Opcion 4");
	
	group.add(radio1);
	group.add(radio2);
	group.add(radio3);
	group.add(radio4);
	
	radio1.addItemListener(this);
	radio2.addItemListener(this);
	radio3.addItemListener(this);
	radio4.addItemListener(this);
	
	contentPane.add(radio1);
	contentPane.add(radio2);
	contentPane.add(radio3);
	contentPane.add(radio4);
	
	text = new JTextField(20);
	contentPane.add(text);
 }
 
 	public void itemStateChanged(ItemEvent e)
	{
	 if (e.getItemSelectable() == radio1)
	  text.setText("Selecciono la casilla  #1");
	 if (e.getItemSelectable() == radio2)
	  text.setText("Selecciono la casilla  #2");
	 if (e.getItemSelectable() == radio3)
	  text.setText("Selecciono la casilla  #3");
	 if (e.getItemSelectable() == radio4)
	  text.setText("Selecciono la casilla  #4");
	}

}

