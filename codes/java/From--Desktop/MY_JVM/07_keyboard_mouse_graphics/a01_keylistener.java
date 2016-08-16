//########### import ###############

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

//########### HTML ###############

/*
<applet 
  codebase="temp"
  code="a01_keylistener.class"
  alt="Probando Applet"
  name="a01_keylistener"
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


//########### a01_keylistener ###############

public class
   a01_keylistener
extends
   Applet
implements
   KeyListener
{

//####### Declarations #######
 String text = "";

 public void init()
 {
  addKeyListener(this);
//  this.requestFocus();
 }

 public void paint(Graphics g)
 {
  g.drawString(text,10,100);
 }

 public void keyTyped(KeyEvent e)
 {
  text += e.getKeyChar();
  repaint();
 }

 public void keyPressed(KeyEvent e) {}
 public void keyReleased(KeyEvent e) {}
}

