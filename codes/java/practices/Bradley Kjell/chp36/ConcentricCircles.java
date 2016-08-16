import javax.swing.JApplet;
import java.awt.*;

public class ConcentricCircles extends JApplet {
public void paint (Graphics g) {
    g.drawOval(200-50, 200-50, 2*50, 2*50);
    g.drawOval(200-100, 200-100, 2*100, 2*100);
    g.drawOval(200-150, 200-150, 2*150, 2*150);
}
}