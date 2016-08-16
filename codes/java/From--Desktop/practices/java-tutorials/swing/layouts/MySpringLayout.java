import java.awt.*;
import javax.swing.*;

class MySpringLayout {
    public static void main (String [] args) {
        new MySpringLayout().buildGUI();
    }
    
    void buildGUI() {
        JFrame frm1 = new JFrame("BorderLayout Practice");
        frm1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container pane = frm1.getContentPane();

        // LAYOUT DEFINITION
        SpringLayout mySpringLayoutTest = new SpringLayout();
        pane.setLayout(mySpringLayoutTest);
        
        JButton button = new JButton("Button 1 (PAGE_START)");

        mySpringLayoutTest.putConstraint(SpringLayout.WEST, button,
                             5,
                             SpringLayout.WEST, pane);
        mySpringLayoutTest.putConstraint(SpringLayout.NORTH, button,
                             5,
                             SpringLayout.NORTH, pane);


        pane.add(button);

        
        
        button = new JButton("Button 2 (CENTER)");          //Make the center component big, 
        button.setPreferredSize(new Dimension(200, 100));   //since that's the typical usage

        mySpringLayoutTest.putConstraint(SpringLayout.WEST, button,
                             5,
                             SpringLayout.WEST, pane);
        mySpringLayoutTest.putConstraint(SpringLayout.NORTH, button,
                             5,
                             SpringLayout.NORTH, pane);
        pane.add(button);

        button = new JButton("Button 3 (LINE_START)");

        mySpringLayoutTest.putConstraint(SpringLayout.WEST, button,
                             5,
                             SpringLayout.WEST, pane);
        mySpringLayoutTest.putConstraint(SpringLayout.NORTH, button,
                             5,
                             SpringLayout.NORTH, pane);
        pane.add(button);

        button = new JButton("Long-Named Button 4 (PAGE_END)");
 
        mySpringLayoutTest.putConstraint(SpringLayout.WEST, button,
                             5,
                             SpringLayout.WEST, pane);
        mySpringLayoutTest.putConstraint(SpringLayout.NORTH, button,
                             5,
                             SpringLayout.NORTH, pane);
       pane.add(button);

        button = new JButton("5 (LINE_END)");

        mySpringLayoutTest.putConstraint(SpringLayout.WEST, button,
                             5,
                             SpringLayout.WEST, pane);
        mySpringLayoutTest.putConstraint(SpringLayout.NORTH, button,
                             5,
                             SpringLayout.NORTH, pane);
        pane.add(button);

        frm1.pack();
        frm1.setSize(640,480);
        frm1.setVisible(true);

    }
}