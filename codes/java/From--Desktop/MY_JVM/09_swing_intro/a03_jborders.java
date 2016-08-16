import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/*
<applet 
  codebase="temp"
  code="a03_jborders.class"
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

public class a03_jborders extends JApplet
{
 jpanel j;
 
 public void init()
 {
  Container contentPane = getContentPane();
	j = new jpanel();
	j.setBorder( BorderFactory.createRaisedBevelBorder() );
	contentPane.add(j);
 }
}

class jpanel extends JPanel
{
 jpanel()
 {
  setBackground(Color.white);
 }
 
 public void paintComponent(Graphics g)
 {
  super.paintComponent(g);
	g.drawString( "Hola desde Swing con a03_jborders" ,
	              getBorder().getBorderInsets(this).left, 
								60
							);
 }
}