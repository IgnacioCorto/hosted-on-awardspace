import javax.swing.JApplet;
import java.awt.*;

// assume that the drawing area is 150 by 150
public class JustOneCircle extends JApplet
{
  final int radius = 25;

  public void paint ( Graphics gr )
  { 
    setBackground( Color.lightGray );
    gr.drawOval( (150/2 - radius), (150/2 - radius), radius*2, radius*2 );
   }
}
