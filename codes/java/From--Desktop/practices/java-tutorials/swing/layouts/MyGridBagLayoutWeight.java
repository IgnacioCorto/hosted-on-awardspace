import java.awt.*;
import javax.swing.*;

class MyGridBagLayout2 {
    public static void main (String [] args) {
        new MyGridBagLayout2().buildGUI();
    }
    
    void buildGUI() {
        JFrame frm1 = new JFrame("BorderLayout Practice");
        frm1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container pane = frm1.getContentPane();

        
       
        frm1.setSize(640,480);
        frm1.setVisible(true);

    }
}