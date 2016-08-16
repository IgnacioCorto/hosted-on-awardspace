//############### import ##############
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

//############### HTML adapter00 ##############
/*
 <applet
  codebase=temp
  code=adapter00.class
  width=200
  height=200
 ></applet
*/


//############### adapter00 ##############
public class adapter00 extends Applet 
{
 public String mensaje = "Hola desde adapter00!!";

  public void init()
  {
   addMouseListener(new raton(this));
  }

  public void paint(Graphics g)
  {
   g.drawString(mensaje,60,100);
  }

}

//############### raton ##############
class raton extends MouseAdapter
{
 adapter00 a;
 raton(adapter00 objetoApplet)
 {
  a = objetoApplet;
 }

 public void mouseClicked(MouseEvent me)
 {
  a.mensaje = "Hola a adapter00!";
  a.repaint();
 }
}


//###############  ##############

