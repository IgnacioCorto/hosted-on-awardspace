import java.awt.*;
import java.awt.event.*;

//######## aa_aplicacion #########
class AppFrame extends Frame
{
 public void paint(Graphics g)
 {
  g.drawString("Hola desde aa_aplicacion!!",15,100);
 }
}

public class aa_aplicacion
{
 public static void main(String[] args)
 {
  AppFrame miFrame = new AppFrame();
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
}
