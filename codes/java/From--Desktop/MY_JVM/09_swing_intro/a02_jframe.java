import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
<applet 
  codebase="temp"
  code="a02_jframe.class"
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

public class a02_jframe extends JFrame
{
 jpanel j;
 
 public a02_jframe()
 {
  super("Aplicacion Swing");
	
  Container contentPane = getContentPane();
	j = new jpanel();
	contentPane.add(j);	
 }
 
 public static void main(String arg[])
 {
  final JFrame f = new a02_jframe();
		
	f.setBounds(100,100,300,300);
	f.setVisible(true);
	f.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	
	f.addWindowListener
	(
	 new WindowAdapter()
	 {
	  public void windowClosing(WindowEvent e)
		{
		 System.exit(0);
		}
	 }
	);
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
	g.drawString("Hola desde Swing con a02_jframe",0,60);
 }
}