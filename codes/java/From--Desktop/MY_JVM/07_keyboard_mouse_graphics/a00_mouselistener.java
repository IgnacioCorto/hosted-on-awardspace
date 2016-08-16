//########### import ###############

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

//########### HTML ###############

/*
<applet 
  codebase="temp"
  code="a00_mouselistener.class"
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


//########### a00_mouselistener ###############

public class
   a00_mouselistener
extends
   Applet
implements
   MouseListener, MouseMotionListener
{

//####### Declarations #######
 TextField text1;

 public void init()
 {
  text1 = new TextField(35);
  add(text1);
  addMouseListener(this);
  addMouseMotionListener(this);
 }

 public void mousePressed(MouseEvent event)
 {
  if( (event.getModifiers() & InputEvent.BUTTON1_MASK) ==
      InputEvent.BUTTON1_MASK)
    {
     text1.setText("Boton Izquierdo apretado en: ("+
      event.getX() + ", " + event.getY() +")");
    }
  else
    {
     text1.setText("Boton Derecho pulsado en: ("+
      event.getX() + ", " + event.getY() +")");
    }
 }


 public void mouseClicked(MouseEvent event)
 {
     text1.setText("Hizo click en: ("+
      event.getX() + ", " + event.getY() +")");
 }

 public void mouseReleased(MouseEvent event)
 {
     text1.setText("Se solto el boton");
 }

 public void mouseEntered(MouseEvent event)
 {
     text1.setText("Raton para introducir");
 }

 public void mouseExited(MouseEvent event)
 {
     text1.setText("Raton para salir");
 }

 public void mouseDragged(MouseEvent event)
 {
     text1.setText("Se arrastro el raton");
 }

 public void mouseMoved(MouseEvent event)
 {
     text1.setText("Se movio el raton");
 }


}

