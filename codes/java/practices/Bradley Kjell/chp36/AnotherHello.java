// Put "Hello" at the center of a 300 by 150 drawing area
//
import javax.swing.JApplet;
import java.awt.*;

public class AnotherHello extends JApplet 
{
  public void paint ( Graphics gr )
  { 
    setBackground( Color.black );
    gr.drawString("Hello", 60, 75 );
   }
}
