import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
<applet 
  codebase="temp"
  code="test.class"
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

public class test extends JApplet
{
 clase_miJPanel miJP;
 
 public test()
 {
  Container miContenedor = getContentPane();
	miJP = new clase_miJPanel();
	miContenedor.add(miJP);
	System.out.println("Desde Constructor");
 }

 public void init()
 {
 	System.out.println("Desde Init");
 }
}

//#####################################################################

class clase_miJPanel extends JPanel
{
 clase_miJPanel()
 {
  setBackground(Color.white);
 }
 
 public void paintComponent (Graphics g)
 {
  super.paintComponent(g);
	g.drawString("Hola desde test", 0, 60);
 }
}

