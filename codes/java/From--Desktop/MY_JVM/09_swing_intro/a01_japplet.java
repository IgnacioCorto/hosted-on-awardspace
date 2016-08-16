import java.awt.*;
import javax.swing.*;

/*
<applet 
  codebase="temp"
  code="a01_japplet.class"
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

public class a01_japplet extends JApplet
{
 jpanel j;
 
 public void init()
 {
  Container contentPane = getContentPane();
	j = new jpanel();
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
	g.drawString("Hola desde Swing con a01_japplet",0,60);
 }
}