import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
// REFERENCE PAGE :  444

public class MyJFrame implements ActionListener {
    JButton button;
    
    public static void main(String [] args) {
        new MyJFrame().go();
    }
    
    public void go() {
        JFrame frame = new JFrame();
        button = new JButton("Click me!");
        button.addActionListener(this);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(button);
        frame.setSize(300,300);
        frame.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent event) {
        button.setText("You have changed me!!!");
    }
    
}