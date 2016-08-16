import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MovingOval extends JPanel {
    int x = 70, y = 70 ;

    public static void main (String [] args) {
        MovingOval obj = new MovingOval();
        obj.executeProgram();
    }

    void executeProgram () {
        JFrame w = new JFrame("Hola");
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        w.setSize(300,300);
        w.setVisible(true);
        
        MDP p = new MDP();
        w.getContentPane().add(p);
        
        for(int i=0; i<100; i++){
            x++;
            y++;
            p.repaint();
            try {
                Thread.sleep(10);
            } catch (Exception ex) {};
        }
        
    }
    
    class MDP extends JPanel {
        protected void paintComponent(Graphics g) {
            g.setColor(Color.white);
            g.fillRect( 0,0,this.getWidth(),this.getHeight() );
            
            g.setColor(Color.yellow);
            g.fillOval(x,y,40,40);
        }
    }
    

}