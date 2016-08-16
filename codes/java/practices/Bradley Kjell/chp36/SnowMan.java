import javax.swing.JApplet;
import java.awt.*;

public class SnowMan extends JApplet {
public void paint (Graphics g) {
    g.drawOval(200-18, 200-66, 2*18, 2*18);
    g.drawOval(200-30, 200-30, 2*30, 2*30);
    g.drawOval(200-41, 200+30, 2*41, 2*41);
    
    g.drawLine(0, 200-30, 400, 200-30);

    g.drawOval(189, 141, 8, 8);
    g.drawOval(202, 141, 8, 8);
    g.drawOval(196, 152, 8, 8);

    g.drawOval(196, 180, 8, 8);
    g.drawOval(196, 195, 8, 8);
    g.drawOval(196, 210, 8, 8);
    
    }
}