import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class FirstLayout extends JPanel {

    public static void main (String [] args) {
        FirstLayout obj = new FirstLayout();
        obj.executeProgram();
    }

    void executeProgram () {
        JFrame w = new JFrame("Hola");
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        w.setSize(300,300);
        w.setVisible(true);
        
        JPanel pl = new JPanel();
        JPanel p2 = new JPanel();
        p2.add( new JButton("Button 1") );
        p2.add( new JButton("Button 2") );
        p2.add( new JButton("Button 3") );
        p1.add( p2 );
    }
   

}