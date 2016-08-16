//########### import ###############

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

//########### HTML ###############

/*
<applet 
  codebase="temp"
  code="a06_canvas_color.class"
  alt="Probando Applet"
  name="a06_canvas_color"
  width="400"
  height="200"
  align="right"
  hspace="40"
  vspace="40"
>
<param name="parametro1" value="Interesante, pero no muy comun">
  Su computadora no soporta JAVA. Favor instalarlo.
</applet>
*/

//########### a06_canvas_color ###############

public class
   a06_canvas_color
extends
   java.applet.Applet
implements
   MouseListener

{ //####### Declarations #######

 graphicsCanvas gc;
 Button button1;
 
//############## init ##############

 public void init()
 {
  gc = new graphicsCanvas();
  gc.setSize  (100,100);
  add(gc);
  addMouseListener(this);
 }

//############## mouseClicked ##############

 public void mouseClicked(MouseEvent e)
  { 
   for(int ii = 0; ii < 150; ii++) gc.setLocation(ii, 0);
  }

//############## mouse[Press/Enter/Exit/Releas]ed ##############

 public void mousePressed(MouseEvent e) { }
 public void mouseReleased(MouseEvent e) { }
 public void mouseEntered(MouseEvent e) { }
 public void mouseExited(MouseEvent e) { }

}

class graphicsCanvas extends java.awt.Canvas
{
 public void paint (Graphics g)
 {
  setForeground(Color.blue);
  setBackground(Color.yellow);
  
  g.drawOval(10,50,40,40);
  g.drawLine(10,50,50,90);
  g.drawLine(50,50,10,90);
 }
}