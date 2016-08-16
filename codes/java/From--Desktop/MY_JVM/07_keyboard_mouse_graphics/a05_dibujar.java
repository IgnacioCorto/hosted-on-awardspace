//########### import ###############

import java.awt.*;
import java.lang.Math;
import java.awt.event.*;
import java.awt.Graphics;
import java.applet.Applet;

//########### HTML ###############

/*
<applet 
  codebase="temp"
  code="a05_dibujar.class"
  alt="Probando Applet"
  name="a05_dibujar"
  width="600"
  height="200"
  align="right"
  hspace="40"
  vspace="40"
>
<param name="parametro1" value="Interesante, pero no muy comun">
  Su computadora no soporta JAVA. Favor instalarlo.
</applet>
*/

//########### a05_dibujar ###############

public class
   a05_dibujar
extends
   Applet
implements
   ActionListener, MouseListener, MouseMotionListener

{ //####### Declarations #######

 Button bDraw, bLine, bOval, bRect, bRounded;
 Point dot[] = new Point[1000];
 Point start, end;
 int dots = 0;
 
 boolean mouseUp = false;
 boolean draw = false;
 boolean line = false;
 boolean oval = false;
 boolean rectangle = false;
 boolean rounded = false;

//############## init ##############

 public void init()
 {
  bLine = new Button("Dibujar Rectas");
  bOval = new Button("Dibujar Ovalos");
  bRect = new Button("Dibujar Rectangulos");
  bRounded = new Button("Dibujar Rectangulos redondeados");
  bDraw = new Button("Dibujo Libre");

  add(bLine);
  add(bOval);
  add(bRect);
  add(bRounded);
  add(bDraw);

  bLine.addActionListener(this);
  bOval.addActionListener(this);
  bRect.addActionListener(this);
  bRounded.addActionListener(this);
  bDraw.addActionListener(this);
  
  addMouseListener(this);
  addMouseMotionListener(this);
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


//############## mouseDragged ##############

 public void mouseDragged(MouseEvent e)
 {
  if(draw)
   {
    dot[dots] = new Point(e.getX(), e.getY());
	dots++;
	repaint();
   }
 }

//############## mouse[Clicked/Entered/Exited] ##############

public void mouseClicked(MouseEvent e) {}
public void mouseEntered(MouseEvent e) {}
public void mouseExited(MouseEvent e) {}
public void mouseMoved(MouseEvent e) {}

//############## paint  ##############

 public void paint(Graphics g)
 {
  if(mouseUp)
   {
    int width = end.x - start.x;
    int height = end.y - start.y;
	
	if(line)
	  g.drawLine(start.x, start.y, end.x, end.y);
	else if(oval)
	  g.drawOval(start.x, start.y, width, height);
	else if(rectangle)
	  g.drawRect(start.x, start.y, width, height);
	else if(rounded)
	  g.drawRoundRect(start.x, start.y, width, height, 10, 30);
	else if(draw)
	  for (int i = 0; i < dots - 1; i++)
	   {
	    g.drawLine( dot[i].x, dot[i].y, dot[i+1].x, dot[i+1].y );
	   }
	 dots=0;
   }
 }

// ############## actionPerformed  ##############

 public void actionPerformed(ActionEvent e)
 {
  setFlagsFalse();
  if(e.getSource() == bDraw) draw = true; 
  if(e.getSource() == bLine) line  = true; 
  if(e.getSource() == bOval) oval  = true; 
  if(e.getSource() == bRect) rectangle  = true; 
  if(e.getSource() == bRounded) rounded  = true; 
 }

// ############## setFlagsFalse  ##############
 
 void setFlagsFalse()
 {
  rounded = false;
  line = false;
  oval = false;
  rectangle = false;
  draw = false;
 }
}