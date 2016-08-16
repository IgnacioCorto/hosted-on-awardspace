import java.awt.*;
import java.awt.event.*;

public class aplicacion
{
 public static void main(String [] args)
 {
  AppFrame f = new AppFrame();
  f.setSize(200,200);
  f.addWindowListener(
    new WindowAdapter()
     {
      public void windowClosing(WindowEvent e)
      {
       System.exit(0);
      }
     }
    );
  f.show();
  }
}

class AppFrame extends Frame
{
 public void paint(Graphics g)
 {
  g.drawString("Hola desde Java!", 60, 100);
 }
}