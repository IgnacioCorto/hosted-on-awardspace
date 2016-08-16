import java.awt.*;
import javax.swing.*;

class MyGroupLayout {
    public static void main (String [] args) {
        new MyGroupLayout().buildGUI();
    }
    
    void buildGUI() {
        JFrame frm1 = new JFrame("BorderLayout Practice");
        frm1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container pane = frm1.getContentPane();

        // LAYOUT DEFINITION
        GroupLayout myGroupLayoutTest = new GroupLayout(pane);
        pane.setLayout(myGroupLayoutTest);

        
        myGroupLayoutTest.setAutoCreateGaps(true);
        myGroupLayoutTest.setAutoCreateContainerGaps(true);
   
   
        JButton c1 = new JButton("Btn #1");
        JButton c2 = new JButton("Btn #2");
        JButton c3 = new JButton("Btn #3");
        JButton c4 = new JButton("Btn #4");
        
        
        myGroupLayoutTest.setHorizontalGroup(
           myGroupLayoutTest.createSequentialGroup()
              .addComponent(c1)
              .addComponent(c2)
              .addGroup(myGroupLayoutTest.createParallelGroup(GroupLayout.Alignment.LEADING)
                   .addComponent(c3)
                   .addComponent(c4))
        );
        
        myGroupLayoutTest.setVerticalGroup(
           myGroupLayoutTest.createSequentialGroup()
              .addGroup(myGroupLayoutTest.createParallelGroup(GroupLayout.Alignment.BASELINE)
                   .addComponent(c1)
                   .addComponent(c2)
                   .addComponent(c3))
              .addComponent(c4)
        );


        // END OF LAYOUT DEFINITION
        
        frm1.setSize(640,480);
        frm1.setVisible(true);

    }
}