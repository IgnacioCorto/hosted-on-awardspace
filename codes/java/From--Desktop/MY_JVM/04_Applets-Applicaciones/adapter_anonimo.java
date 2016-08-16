import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

//########### adapter_anonimo ##############

public class adapter_anonimo extends Applet
{
 public String mensaje = "adapter_anonimo: Hola??";

 public void init()
 {
  addMouseListener(
   new MouseAdapter()
   {
    public void mousePressed(MouseEvent me)
    {
     mensaje = "Mensaje respondido!!";
     repaint();
    }
   }
  );
 }

  public void paint(Graphics g)
  {
   g.drawString(mensaje, 15,100);
  }


}


/*
	<applet
	  codebase=temp
	  code=adapter_anonimo
	  width=200
	  height=200
	></applet>
*/