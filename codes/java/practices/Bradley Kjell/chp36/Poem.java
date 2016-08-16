import javax.swing.JApplet;
import java.awt.*;

public class Poem extends JApplet
{
  public void paint ( Graphics gr )
  { 
    setBackground( Color.white );
    gr.drawString("Loveliest of trees, the cherry now", 25, 30);
    gr.drawString("Is hung with bloom along the bough,", 25, 50);
    gr.drawString("And stands about the woodland ride", 25, 70 );
    gr.drawString("Wearing white for Eastertide." ,25, 90);
    gr.drawString("--- A. E. Housman" ,50, 130);
   }
}
