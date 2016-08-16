//########### import ###############

import java.awt.*;
import java.applet.Applet;
import java.awt.event.*;
import java.lang.Math;

//########### HTML ###############

/*
<applet 
  codebase="temp"
  code="a04_redimension.class"
  alt="Probando Applet"
  name="a04_redimension"
  width="600"
  height="300"
  align="right"
  hspace="40"
  vspace="40"
>
<param name="parametro1" value="Interesante, pero no muy comun">
  Su computadora no soporta JAVA. Favor instalarlo.
</applet>
*/

//########### a04_redimension ###############

public class
   a04_redimension
extends
   Applet
implements
   MouseListener

{ //####### Declarations #######

 Image image;
 boolean mouseUp = false;
 Point start, end;
 
//############## init ##############

 public void init()
 {
  image = getImage(getDocumentBase(),"temp/image.jpg");
  addMouseListener(this);
 }

//############## mousePressed ##############

 public void mousePressed(MouseEvent e)
 {
  mouseUp = false;
  start = new Point(e.getX(), e.getY());
 }

//############## mousePressed ##############

 public void mouseReleased(MouseEvent e)
 {
  mouseUp = true;
  end = new Point( Math.max(e.getX(), start.x),
        Math.max(e.getY(), start.y) );
  start = new Point( Math.min(e.getX(), start.x),
        Math.min(e.getY(), start.y) );
  repaint();
 }

//############## mouse[Clicked/Entered/Exited] ##############

public void mouseClicked(MouseEvent e) {}
public void mouseEntered(MouseEvent e) {}
public void mouseExited(MouseEvent e) {}

//############## paint  ##############

 public void paint(Graphics g)
 {
  if(mouseUp)
   {
    int width = end.x - start.x;
    int height = end.y - start.y;
    g.drawImage(image, start.x, start.y, width, height,this);
   }
 }
 
}