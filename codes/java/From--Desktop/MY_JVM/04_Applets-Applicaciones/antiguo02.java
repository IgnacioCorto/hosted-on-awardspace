//############### import ##############
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

//############### HTML antiguo02 ##############
/*
 <applet
  codebase=temp
  code=antiguo02.class
  width=200
  height=200
 ></applet
*/

//############### nuevoBoton ##############
class nuevoBoton extends Button
{
 antiguo02 a;

 nuevoBoton(antiguo02 aref, String s)
 {
  super(s);
  a = aref;
  enableEvents(AWTEvent.ACTION_EVENT_MASK);
 }

 protected void processActionEvent (ActionEvent e)
 {
  super.processActionEvent(e);
  a.miTexto.setText("Hola desde 'antiguo02'!!");
 }
}

//############### antiguo02 ##############
public class antiguo02 extends Applet 
{
 TextField miTexto;
 Button miBoton;

  public void init()
  {
   miTexto = new TextField(20);
   add(miTexto);
   miBoton = new nuevoBoton(this, "Haga click aqui!");
   add(miBoton);
  }

}

//############### ##############


