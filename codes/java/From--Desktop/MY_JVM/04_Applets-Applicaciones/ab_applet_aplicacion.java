import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

import java.awt.*;
import java.awt.event.*;

/*
	<applet
	  codebase=temp
	  code=ab_applet_aplicacion.class
	  width=200
	  height=200
	></applet>
*/

// ########### ab_applet_aplicacion ###########

public class ab_applet_aplicacion extends Applet
{
 public static void main(String[] args)
 {
  miAppFrame miFrame = new miAppFrame();
  miFrame.setSize(200,200);

  miFrame.addWindowListener(
   new WindowAdapter()
   {
    public void windowClosing(WindowEvent e)
    {
     System.exit(0);
    }
   }
  );

 miFrame.show();
 }

 public void paint(Graphics miGrafico)
 {
  miGrafico.drawString("ab_applet_mode: Hola!!",10,100);
 }
}

class miAppFrame extends Frame
{
 public void paint(Graphics miGrafico)
 {
  miGrafico.drawString("ab_application_mode: Hola!!",10,100);
 }
}