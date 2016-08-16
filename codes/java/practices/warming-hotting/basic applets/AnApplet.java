import javax.swing.JApplet;
import java.awt.Graphics;
import java.awt.Color;

public class AnApplet extends JApplet {
    public void paint(Graphics g) {

        this.setBackground(Color.red);
        g.setColor(Color.cyan);
        //vertical-align:bottom;
        g.drawString("Hola Mundo", 0,50);
        
        this.setBackground(Color.green);
        g.setColor(Color.magenta);
        g.drawOval(0,50,40,40);
        
        this.setBackground(Color.blue);
        g.setColor(Color.yellow);
        g.drawRect(0,100,40,40);
        
        this.setBackground(Color.lightGray);
        g.setColor(Color.black);
        g.drawLine(0,150,40,190);

    }
}