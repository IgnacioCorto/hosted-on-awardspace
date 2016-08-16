import java.awt.*;
import javax.swing.*;

class MyFlowLayout {
    public static void main (String [] args) {
        new MyFlowLayout().buildGUI();
    }
    
    void buildGUI() {
        JFrame frm1 = new JFrame("BorderLayout Practice");
        frm1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container pane = frm1.getContentPane();

        FlowLayout myFlowLayoutTest = new FlowLayout(FlowLayout.TRAILING);
        pane.setLayout(myFlowLayoutTest);
        
        JButton button = new JButton("Button 1 (PAGE_START)");
        pane.add(button);

        button = new JButton("Button 2 (CENTER)");          //Make the center component big, 
        button.setPreferredSize(new Dimension(200, 100));   //since that's the typical usage
        pane.add(button);

        button = new JButton("Button 3 (LINE_START)");
        pane.add(button);

        button = new JButton("Long-Named Button 4 (PAGE_END)");
        pane.add(button);

        button = new JButton("5 (LINE_END)");
        pane.add(button);

        pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        
        frm1.setSize(640,480);
        frm1.setVisible(true);

    }
}