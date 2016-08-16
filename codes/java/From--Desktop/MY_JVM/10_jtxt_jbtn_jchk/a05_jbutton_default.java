// SOLO FUNCIONAN:
// normal, Rollover, Pressed, Disabled

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/*
<applet 
  codebase="temp"
  code="a05_jbutton_default.class"
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

public class a05_jbutton_default extends JApplet
{
 JButton button1 = new JButton("Haga click aqui");
 JButton button2 = new JButton("Haga click aqui");
 JTextField text = new JTextField(20);

 public void init()
 {
	 Container contentPane = getContentPane();
	 contentPane.setLayout(new FlowLayout());
	 
   button2.setMnemonic('H');
	 getRootPane().setDefaultButton(button2);
	 getRootPane().requestFocus();
	 
	 contentPane.add(button1);
	 contentPane.add(button2);
	 contentPane.add(text);
	 
	 button1.addActionListener(new ActionListener(){
	  public void actionPerformed(ActionEvent evet) {
		 text.setText("Hola desde Boton 1"); }} );

	 button2.addActionListener(new ActionListener(){
	  public void actionPerformed(ActionEvent evet) {
		 text.setText("Hola desde Boton 2"); }} );
 }
}

