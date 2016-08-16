import javax.swing.JApplet;
import java.awt.*;

public class Asterisk extends JApplet {
public void paint (Graphics g) {
    
    g.drawLine(0, 0, 400, 400);
    g.drawLine(0, 200, 400, 200);
    g.drawLine(0, 400, 400, 0);
    g.drawLine(200, 0, 200, 400);
    
    }
}