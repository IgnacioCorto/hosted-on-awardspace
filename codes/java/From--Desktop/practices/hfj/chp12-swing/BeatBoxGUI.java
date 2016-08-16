import javax.swing.*;
import java.awt.event.*;

class BeatBoxGUI { 
    JButton btn1;

    public static void main ( String [] args ) {
        new BeatBoxGUI();
    }
    
    BeatBoxGUI() {

        JFrame frm1 = new JFrame();
        btn1 = new JButton("Click me!");
        btn1.addActionListener(new Btn1Listener());
        
        frm1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm1.getContentPane().add(btn1);
        frm1.setSize(300,300);

        /* =============================== */
        frm1.setVisible(true);
    }
    
    class Btn1Listener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            btn1.setText("You have changed me!!!");
        }
    }

}