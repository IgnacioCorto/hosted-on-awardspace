import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/*
<applet 
  codebase="temp"
  code="a03_jbutton.class"
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

public class a03_jbutton extends JApplet
{
 JButton button = new JButton("Haga clic aqui",
 															new ImageIcon("temp/icon.jpg"));
 JTextField text = new JTextField(20);
 
 public void init()
 {
  Container contentPane = getContentPane();

	contentPane.setLayout(new FlowLayout());
	contentPane.add(button);
	contentPane.add(text);
	
	button.addActionListener(
	 new ActionListener() {
		public void actionPerformed ( ActionEvent event ) {
		 text.setText("Hola desde a03_jbutton"); }});   
 }
}

